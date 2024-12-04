package com.slippery.ecs.service.impl;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;
import com.slippery.ecs.repository.CartRepository;
import com.slippery.ecs.service.CartService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository repository;

    public CartServiceImpl(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public CartDto createNewCart(Cart cartDetails) {
        return null;
    }

    @Override
    public CartDto updateCart(Cart cartDetails, Long id) {
        return null;
    }

    @Override
    public CartDto clearCart(long id) {
        CartDto response =new CartDto();

        return null;
    }
}
