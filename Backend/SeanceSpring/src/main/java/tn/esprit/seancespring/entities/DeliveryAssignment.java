package tn.esprit.seancespring.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delivery_assignment")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "delivery_agent_id")
    private User deliveryAgent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedDate;

    // Constructors, getters, and setters
}