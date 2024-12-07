package com.slippery.ecs.service;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;

public interface CartService {
    CartDto getCartById(Long id);
    CartDto updateCart(Cart cartDetails,Long id);
    CartDto addItemToCart(Long itemId,Long UserId,Long cartId);
    CartDto clearCart(Long cartId);
}
