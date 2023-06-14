package tn.esprit.seancespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.seancespring.entities.Order;
import tn.esprit.seancespring.services.IOrderService;
import tn.esprit.seancespring.services.OrderServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
@Autowired
    IOrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.GetAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("order_id") Long order_id) {
        Optional<Order> order = Optional.ofNullable(orderService.getOrderById(order_id));
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Order>> GetOrdersByUserId(@PathVariable("id") Long id) {
        List<Order> orders = orderService.GetOrdersByUserId(id);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @DeleteMapping("/{order_id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("order_id") Long order_id) {
        orderService.deleteOrder(order_id);
        return ResponseEntity.noContent().build();
    }
}
