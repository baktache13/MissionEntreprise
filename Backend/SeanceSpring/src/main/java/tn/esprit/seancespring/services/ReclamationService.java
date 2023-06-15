package tn.esprit.seancespring.services;

import org.springframework.stereotype.Service;
import tn.esprit.seancespring.entities.Product;
import tn.esprit.seancespring.entities.Reclamation;
import tn.esprit.seancespring.entities.User;
import tn.esprit.seancespring.exception.ResourceNotFoundException;
import tn.esprit.seancespring.repositories.ProductRepository;
import tn.esprit.seancespring.repositories.ReclamationRepository;
import tn.esprit.seancespring.repositories.UserRepository;

import java.util.List;

@Service
public class ReclamationService {

    private final ReclamationRepository reclamationRepository;
    private final UserRepository userRepository;

    public ReclamationService(ReclamationRepository reclamationRepository, UserRepository userRepository) {
        this.reclamationRepository = reclamationRepository;
        this.userRepository = userRepository;
    }

    public Reclamation createReclamation(Long userId, Reclamation reclamationRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found student with id = " + userId));

        reclamationRequest.setUser(user);
        return reclamationRepository.save(reclamationRequest);
    }

    public List<Reclamation> getReclamationsByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("StudentNotFoud");
        }

        return reclamationRepository.findByUserId(userId);
    }


    public Reclamation findById(Long id) {
        return reclamationRepository.findById(id).orElse(null);
    }

    public List<Reclamation> findAll() {
        return reclamationRepository.findAll();
    }

}
