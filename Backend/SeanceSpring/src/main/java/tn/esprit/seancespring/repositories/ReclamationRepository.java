package tn.esprit.seancespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.seancespring.entities.Reclamation;

import java.util.List;
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

    List<Reclamation> findByUserId(Long userId);

}
