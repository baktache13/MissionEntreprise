package tn.esprit.seancespring.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.seancespring.entities.OrderProduct;
import tn.esprit.seancespring.entities.OrderProductKey;
import tn.esprit.seancespring.services.IOrderProductService;

import java.util.List;

@RestController
@RequestMapping("/orderProducts")
public class OrderProductController {
    private final IOrderProductService orderProductService;

    public OrderProductController(IOrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @PostMapping
    public OrderProduct saveOrderProduct(@RequestBody OrderProduct orderProduct) {
        return orderProductService.saveOrderProduct(orderProduct);
    }

    @GetMapping("/{orderId}/{productId}")
    public OrderProduct getOrderProductById(@PathVariable Long orderId, @PathVariable Long productId) {
        OrderProductKey orderProductKey = new OrderProductKey(orderId, productId);
        return orderProductService.getOrderProductById(orderProductKey);
    }
    @GetMapping("/order/{orderId}")
    public List<OrderProduct> getOrderProductsByOrderId(@PathVariable Long orderId) {
        return orderProductService.getOrderProductsByOrderId(orderId);
    }

    @GetMapping("/all")
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductService.getAllOrderProducts();
    }

    @DeleteMapping("/{orderId}/{productId}")
    public void deleteOrderProduct(@PathVariable Long orderId, @PathVariable Long productId) {
        OrderProductKey orderProductKey = new OrderProductKey(orderId, productId);
        orderProductService.deleteOrderProduct(orderProductKey);
    }
}