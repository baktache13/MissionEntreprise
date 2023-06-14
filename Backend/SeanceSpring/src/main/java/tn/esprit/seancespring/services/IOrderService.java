package tn.esprit.seancespring.services;

import tn.esprit.seancespring.entities.Order;

import java.util.List;

public interface IOrderService {
    List<Order> GetAllOrders();

    Order getOrderById(Long order_id);
    List<Order> GetOrdersByUserId(Long id);


    Order saveOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrder(Long order_id);
}
