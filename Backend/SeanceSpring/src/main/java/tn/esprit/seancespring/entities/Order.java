package tn.esprit.seancespring.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Personne personne;

    private LocalDate orderDate;
    private BigDecimal totalAmount;
    private String adresse;
    private String Gov;

}