package tn.esprit.seancespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.seancespring.entities.Activite;

public interface ActiviteRepository extends JpaRepository<Activite,Long> {
}
