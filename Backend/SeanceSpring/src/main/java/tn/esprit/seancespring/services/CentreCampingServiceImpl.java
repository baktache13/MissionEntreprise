package tn.esprit.seancespring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.seancespring.entities.CentreCamping;
import tn.esprit.seancespring.repositories.CentreCampingRepository;

import java.util.List;

@Service
public class CentreCampingServiceImpl implements ICentreCampingService {

    @Autowired
    CentreCampingRepository centreCampingRepository;
    @Override
    public List<CentreCamping> GetAllCenters() {
        return centreCampingRepository.findAll();
    }

    @Override
    public CentreCamping getCenterById(Long id) {
        return centreCampingRepository.findById(id).get();
    }

    @Override
    public CentreCamping saveCenter(CentreCamping centre) {
        return centreCampingRepository.save(centre);
    }

    @Override
    public CentreCamping updateCenter(CentreCamping centre) {
        return centreCampingRepository.save(centre);
    }

    @Override
    public void deleteCenter(Long id) {
        centreCampingRepository.deleteById(id);
    }
}
