package tn.esprit.seancespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.seancespring.entities.ERole;
import tn.esprit.seancespring.entities.Role;
import tn.esprit.seancespring.entities.User;
import tn.esprit.seancespring.payload.request.LoginRequest;
import tn.esprit.seancespring.payload.request.SignupRequest;
import tn.esprit.seancespring.payload.response.JwtResponse;
import tn.esprit.seancespring.payload.response.MessageResponse;
import tn.esprit.seancespring.repositories.RoleRepository;
import tn.esprit.seancespring.repositories.UserRepository;
import tn.esprit.seancespring.security.jwt.JwtUtils;
import tn.esprit.seancespring.services.UserDetailsImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/createuser")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role candidatRole = roleRepository.findByName(ERole.ROLE_VISITEUR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(candidatRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "livreur":
                        Role scoRole = roleRepository.findByName(ERole.ROLE_LIVREUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(scoRole);

                        break;
                    case "responsableLivreur":
                        Role cupRole = roleRepository.findByName(ERole.ROLE_RESPONSABLE_LIVRAISON)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(cupRole);

                        break;
        /*default:
          Role ensRole = roleRepository.findByName(ERole.ROLE_VISITEUR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(ensRole);*/
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
