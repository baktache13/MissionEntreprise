package tn.esprit.seancespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.seancespring.entities.DeliveryAssignment;

import java.util.List;

public interface DeliveryAssignmentRepository extends JpaRepository<DeliveryAssignment, Long> {
    List<DeliveryAssignment> findByDeliveryAgentId(Long agentId);
}
