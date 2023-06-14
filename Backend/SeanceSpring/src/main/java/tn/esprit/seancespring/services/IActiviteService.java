package tn.esprit.seancespring.services;

import tn.esprit.seancespring.entities.Activite;
import tn.esprit.seancespring.entities.CentreCamping;

import java.util.List;

public interface IActiviteService {
    List<Activite> GetAllActivites();

    Activite getActById(Long id);

    Activite saveActivite(Activite s);

    Activite updateActivite(Activite s);

    void deleteActivite(Long id);

    Activite addActiviteAndAssignToCentre(Activite act,Long idCentre);
}
