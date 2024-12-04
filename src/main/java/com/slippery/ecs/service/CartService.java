package com.slippery.ecs.service;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;

public interface CartService {
    CartDto createNewCart(Cart cartDetails);
    CartDto updateCart(Cart cartDetails,Long id);
    CartDto clearCart(long id);
}
