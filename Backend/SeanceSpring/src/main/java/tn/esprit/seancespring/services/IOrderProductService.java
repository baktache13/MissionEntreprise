package tn.esprit.seancespring.services;

import tn.esprit.seancespring.entities.OrderProduct;
import tn.esprit.seancespring.entities.OrderProductKey;

import java.util.List;


public interface IOrderProductService {
    List<OrderProduct> getOrderProductsByOrderId(Long orderId);

    OrderProduct saveOrderProduct(OrderProduct orderProduct);
    OrderProduct getOrderProductById(OrderProductKey orderProductKey);
    List<OrderProduct> getAllOrderProducts();
    void deleteOrderProduct(OrderProductKey orderProductKey);
}
