package com.slippery.ecs.controller;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.service.CartService;
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
    @GetMapping("/add/items")
    public ResponseEntity<CartDto> addItemToCart(@RequestParam Long itemId,@RequestParam Long UserId){
        return ResponseEntity.ok(service.addItemToCart(itemId,UserId));
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
