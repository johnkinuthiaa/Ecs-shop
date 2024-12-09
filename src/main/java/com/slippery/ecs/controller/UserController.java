package com.slippery.ecs.controller;

import com.slippery.ecs.dto.UserDto;
import com.slippery.ecs.models.User;
import com.slippery.ecs.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;

    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody User userDetails){
        return ResponseEntity.ok(service.register(userDetails));
    }
}
