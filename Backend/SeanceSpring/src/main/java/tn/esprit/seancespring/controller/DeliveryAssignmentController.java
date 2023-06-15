package tn.esprit.seancespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.esprit.seancespring.entities.DeliveryAssignment;
import tn.esprit.seancespring.services.IDeliveryAssignmentService;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryAssignmentController {
    private final IDeliveryAssignmentService deliveryAssignmentService;

    @Autowired
    public DeliveryAssignmentController(IDeliveryAssignmentService deliveryAssignmentService) {
        this.deliveryAssignmentService = deliveryAssignmentService;
    }

    @GetMapping("/all")
    public List<DeliveryAssignment> getAllDeliveryAssignments() {
        return deliveryAssignmentService.getAllDeliveryAssignments();
    }

    @GetMapping("/{id}")
    public DeliveryAssignment getDeliveryAssignmentById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return deliveryAssignmentService.getDeliveryAssignmentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryAssignment createDeliveryAssignment(@Validated @RequestBody DeliveryAssignment deliveryAssignment) {
        return deliveryAssignmentService.createDeliveryAssignment(deliveryAssignment);
    }

    @PutMapping("/{id}")
    public DeliveryAssignment updateDeliveryAssignment(
            @PathVariable Long id,
            @Validated @RequestBody DeliveryAssignment deliveryAssignment) throws ChangeSetPersister.NotFoundException {
        return deliveryAssignmentService.updateDeliveryAssignment(id, deliveryAssignment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeliveryAssignment(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        deliveryAssignmentService.deleteDeliveryAssignment(id);
    }

    @GetMapping("/agent/{agentId}")
    public List<DeliveryAssignment> getAssignedDeliveriesByAgentId(@PathVariable Long agentId) {
        return deliveryAssignmentService.getAssignedDeliveriesByAgentId(agentId);
    }
}