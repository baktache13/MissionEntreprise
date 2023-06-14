package tn.esprit.seancespring.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductKey implements Serializable {

    @Column(name = "order_id", insertable = false, updatable = false)
    private Long orderId;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Long productId;

}