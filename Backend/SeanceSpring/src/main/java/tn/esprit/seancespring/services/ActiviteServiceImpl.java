package tn.esprit.seancespring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.seancespring.entities.Activite;
import tn.esprit.seancespring.repositories.ActiviteRepository;

import java.util.List;

@Service
public class ActiviteServiceImpl implements IActiviteService {

    @Autowired
    ActiviteRepository activiteRepository;

    @Override
    public List<Activite> GetAllActivites() {
        return activiteRepository.findAll();
    }

    @Override
    public Activite getActById(Long id) {
        return activiteRepository.findById(id).get();
    }

    @Override
    public Activite saveActivite(Activite act) {
        return activiteRepository.save(act);
    }

    @Override
    public Activite updateActivite(Activite act) {
        return activiteRepository.save(act);
    }

    @Override
    public void deleteActivite(Long id) {
        activiteRepository.deleteById(id);
    }
}
