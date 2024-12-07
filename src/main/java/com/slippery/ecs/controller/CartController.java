package com.slippery.ecs.controller;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin

public class CartController {
    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }
    @GetMapping("/add/items")
    public ResponseEntity<CartDto> addItemToCart(@RequestParam Long itemId,@RequestParam Long UserId,@RequestParam Long cartId){
        return ResponseEntity.ok(service.addItemToCart(itemId,UserId,cartId));
    }
    @GetMapping("/get/cart")
    public CartDto getCartById(@RequestParam Long id){
        return service.getCartById(id);
    }
    @DeleteMapping("/clear/cart")
    public CartDto clearCart(@RequestParam long id){
        return service.clearCart(id);
    }

}
