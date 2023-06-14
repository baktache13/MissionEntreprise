package tn.esprit.seancespring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.seancespring.entities.OrderProduct;
import tn.esprit.seancespring.entities.OrderProductKey;
import tn.esprit.seancespring.repositories.OrderProductRepository;

import java.util.List;

@Service
public class OrderProductServiceImp implements IOrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;

    public OrderProductServiceImp(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    @Override
    public OrderProduct getOrderProductById(OrderProductKey orderProductKey) {
        return orderProductRepository.findById(orderProductKey).orElse(null);
    }
    @Override
    public List<OrderProduct> getOrderProductsByOrderId(Long orderId) {
        return orderProductRepository.findByOrderId(orderId);
    }


    @Override
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductRepository.findAll();
    }

    @Override
    public void deleteOrderProduct(OrderProductKey orderProductKey) {
        orderProductRepository.deleteById(orderProductKey);
    }
}
