package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private static final List<Order> ORDERS = List.of(
            new Order(1L, 1L, 1500.0, "RUB", List.of("Товар 1", "Товар 2"))
    );

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        List<Order> userOrders = ORDERS.stream()
                .filter(o -> o.getUserId().equals(userId))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userOrders);
    }
}