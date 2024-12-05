package com.slippery.ecs.service;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;
import com.slippery.ecs.models.ShopItem;

public interface CartService {
    CartDto getCartById(Long id);
    CartDto updateCart(Cart cartDetails,Long id);
    CartDto addItemToCart(ShopItem item,long userId,long cartId);
    CartDto clearCart(Long cartId);
}
