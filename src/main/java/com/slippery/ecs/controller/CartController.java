package com.slippery.ecs.controller;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.service.CartService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin
public class CartController {
    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }
//    @PostMapping("/create/new")
//    public ResponseEntity<CartDto> createCart(@RequestParam Long userId){
//        return ResponseEntity.ok(service.createNewCart(userId));
//    }
    @PostMapping("/add/items")
    public ResponseEntity<CartDto> addItemToCart(@RequestBody ShopItem item,@RequestParam long userId,@RequestParam long cartId){
        return ResponseEntity.ok(service.addItemToCart(item, userId, cartId));
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
