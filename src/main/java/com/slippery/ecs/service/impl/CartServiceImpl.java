package com.slippery.ecs.service.impl;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;
import com.slippery.ecs.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
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
        return null;
    }
}
