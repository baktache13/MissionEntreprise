package tn.esprit.seancespring.services;

import tn.esprit.seancespring.entities.CentreCamping;

import java.util.List;

public interface ICentreCampingService {
    List<CentreCamping> GetAllCenters();

    CentreCamping getCenterById(Long id);

    CentreCamping saveCenter(CentreCamping s);

    CentreCamping updateCenter(CentreCamping s);

    void deleteCenter(Long id);

}
