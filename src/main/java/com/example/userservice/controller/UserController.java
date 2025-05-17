package com.example.userservice.controller;

import com.example.userservice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Map<Long, User> USERS = Map.of(
            1L, new User(1L, "Иван Иванов", "ул. Ленина, 1", "+79991234567", "ivan@example.com")
    );

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = USERS.get(userId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}
