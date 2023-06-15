package tn.esprit.seancespring.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import tn.esprit.seancespring.entities.DeliveryAssignment;

import java.util.List;

public interface IDeliveryAssignmentService {
    List<DeliveryAssignment> getAllDeliveryAssignments();
    DeliveryAssignment getDeliveryAssignmentById(Long id) throws ChangeSetPersister.NotFoundException;
    DeliveryAssignment createDeliveryAssignment(DeliveryAssignment deliveryAssignment);
    DeliveryAssignment updateDeliveryAssignment(Long id, DeliveryAssignment deliveryAssignment) throws ChangeSetPersister.NotFoundException;
    void deleteDeliveryAssignment(Long id) throws ChangeSetPersister.NotFoundException;
    List<DeliveryAssignment> getAssignedDeliveriesByAgentId(Long agentId);
}