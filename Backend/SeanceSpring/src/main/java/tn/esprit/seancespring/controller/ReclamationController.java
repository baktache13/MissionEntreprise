package tn.esprit.seancespring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tn.esprit.seancespring.entities.Product;
import tn.esprit.seancespring.entities.Reclamation;
import tn.esprit.seancespring.exception.ResourceNotFoundException;
import tn.esprit.seancespring.services.ReclamationService;

import java.util.List;

@Component
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reclamation")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;

    @GetMapping
    public ResponseEntity<List<Reclamation>> findAll() {
        List<Reclamation> reclamations = reclamationService.findAll();
        return ResponseEntity.ok(reclamations);
    }

    @PostMapping("/{userId}")
  //  @PreAuthorize("#userId == authentication.principal.id")
    public ResponseEntity<Reclamation> createReclamation(@PathVariable(value = "userId") Long userId,
                                                         @RequestBody Reclamation reclamationRequest) {
        Reclamation reclamation = reclamationService.createReclamation(userId, reclamationRequest);
        return new ResponseEntity<>(reclamation, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public List<Reclamation> getReclamationsByStudentId(@PathVariable Long userId) {
        return reclamationService.getReclamationsByUserId(userId);
    }



}
