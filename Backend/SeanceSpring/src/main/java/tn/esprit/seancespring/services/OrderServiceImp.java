package tn.esprit.seancespring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.seancespring.entities.Order;
import tn.esprit.seancespring.repositories.OrderRepository;

import java.util.List;
@Service
public class OrderServiceImp implements IOrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> GetAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long order_id) {
        return orderRepository.findById(order_id).get();
    }

    @Override
    public List<Order> GetOrdersByUserId(Long id) {
        return orderRepository.findOrdersByUserId(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long order_id) {

    }
}
