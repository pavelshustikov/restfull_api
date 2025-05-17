package com.example.bffservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("bff")
public class BffServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BffServiceApplication.class, args);
    }
}