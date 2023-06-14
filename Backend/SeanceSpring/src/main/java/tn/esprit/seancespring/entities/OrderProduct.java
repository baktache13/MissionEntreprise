package tn.esprit.seancespring.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
@Data
@Setter
@Getter
@AllArgsConstructor
public class OrderProduct {
    @EmbeddedId
    private OrderProductKey id;

    private Integer quantity;

//    @ManyToOne
//   @JoinColumn(name = "order_id")
//  private Order order;
//
//   @ManyToOne
//   @JoinColumn(name = "product_id")
//   private Product product;


    public OrderProduct() {
        this.id = new OrderProductKey();
    }

//    public OrderProduct(Order order, Product product) {
//        this();
//        this.order = order;
////        this.product = product;
//    }

}
