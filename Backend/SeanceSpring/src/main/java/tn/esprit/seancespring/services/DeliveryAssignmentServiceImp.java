package tn.esprit.seancespring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import tn.esprit.seancespring.entities.DeliveryAssignment;
import tn.esprit.seancespring.repositories.DeliveryAssignmentRepository;

import java.util.List;

@Service
public class DeliveryAssignmentServiceImp implements IDeliveryAssignmentService {
    private final DeliveryAssignmentRepository deliveryAssignmentRepository;

    @Autowired
    public DeliveryAssignmentServiceImp(DeliveryAssignmentRepository deliveryAssignmentRepository) {
        this.deliveryAssignmentRepository = deliveryAssignmentRepository;
    }

    @Override
    public List<DeliveryAssignment> getAllDeliveryAssignments() {
        return deliveryAssignmentRepository.findAll();
    }

    @Override
    public DeliveryAssignment getDeliveryAssignmentById(Long id) throws ChangeSetPersister.NotFoundException {
        return deliveryAssignmentRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    @Override
    public DeliveryAssignment createDeliveryAssignment(DeliveryAssignment deliveryAssignment) {
        return deliveryAssignmentRepository.save(deliveryAssignment);
    }

    @Override
    public DeliveryAssignment updateDeliveryAssignment(Long id, DeliveryAssignment deliveryAssignment) throws ChangeSetPersister.NotFoundException {
        if (!deliveryAssignmentRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }
        deliveryAssignment.setAssignmentId(id);
        return deliveryAssignmentRepository.save(deliveryAssignment);
    }

    @Override
    public void deleteDeliveryAssignment(Long id) throws ChangeSetPersister.NotFoundException {
        if (!deliveryAssignmentRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }
        deliveryAssignmentRepository.deleteById(id);
    }

    @Override
    public List<DeliveryAssignment> getAssignedDeliveriesByAgentId(Long agentId) {
        return deliveryAssignmentRepository.findByDeliveryAgentId(agentId);
    }
}
