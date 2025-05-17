package com.example.bffservice.controller;

import com.example.bffservice.model.Order;
import com.example.bffservice.model.User;
import com.example.bffservice.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long userId) {
        String userServiceUrl = "http://localhost:8081/api/users/" + userId;
        String orderServiceUrl = "http://localhost:8082/api/orders/by-user/" + userId;

        User user = restTemplate.getForObject(userServiceUrl, User.class);
        List<Order> orders = Arrays.asList(restTemplate.getForObject(orderServiceUrl, Order[].class));

        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new UserProfile(user, orders));
    }
}