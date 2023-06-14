package tn.esprit.seancespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.seancespring.entities.Activite;
import tn.esprit.seancespring.entities.CentreCamping;

public interface ActiviteRepository extends JpaRepository<Activite,Long> {

    //boolean existsByIdAndCentreCamping(Long activiteId, CentreCamping centre);

}
