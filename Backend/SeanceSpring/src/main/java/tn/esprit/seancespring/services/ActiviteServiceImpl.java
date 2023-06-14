package tn.esprit.seancespring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.seancespring.entities.Activite;
import tn.esprit.seancespring.entities.CentreCamping;
import tn.esprit.seancespring.repositories.ActiviteRepository;
import tn.esprit.seancespring.repositories.CentreCampingRepository;

import java.util.List;

@Service
public class ActiviteServiceImpl implements IActiviteService {

    @Autowired
    ActiviteRepository activiteRepository;

    @Autowired
    CentreCampingRepository centreCampingRepository;

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

    @Override
    public Activite addActiviteAndAssignToCentre(Activite act, Long idCentre) {
        CentreCamping centre = centreCampingRepository.findById(idCentre).get();
        // Vérifier si l'activité est déjà assignée au centre
        /*if (activiteRepository.existsByIdAndCentreCamping(act.getId(), centre)) {
            throw new IllegalArgumentException("L'activité est déjà assignée à ce centre.");
        }*/
        act.setCentreCamping(centre);
        return activiteRepository.save(act);
    }
}
