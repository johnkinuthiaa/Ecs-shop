package com.slippery.ecs.controller;

import com.slippery.ecs.dto.ShopItemDto;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.service.ShopItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopItemController {

    /*
    shop item controller
     */
    private final ShopItemService service;

    public ShopItemController(ShopItemService service) {
        this.service = service;
    }
    @PostMapping("/create/new")
    public ResponseEntity<ShopItemDto> createNewItem(@RequestBody ShopItem shopItemDetails){
        return ResponseEntity.ok(service.createNewItem(shopItemDetails));
    }
    @PutMapping("/update")
    public ResponseEntity<ShopItemDto> updateItem(@RequestBody ShopItem shopItemDetails,@RequestParam Long id){
        return ResponseEntity.ok(service.UpdateItem(shopItemDetails,id));
    }
    @GetMapping("/find/id")
    public ResponseEntity<ShopItemDto> findItemById(@RequestParam Long id){
        return ResponseEntity.ok(service.findItemById(id));
    }
    @GetMapping("/find/category")
    public ResponseEntity<ShopItemDto> findItemByCategory(@RequestParam String category){
        return ResponseEntity.ok(service.findItemByCategory(category));
    }
    @GetMapping("/find/name")
    public ResponseEntity<ShopItemDto> findItemByName(@RequestParam String name){
        return ResponseEntity.ok(service.findItemByName(name));
    }
    @GetMapping("/find/offer")
    public ResponseEntity<ShopItemDto> findItemByOffer(@RequestParam Boolean offer){
        return ResponseEntity.ok(service.findItemByOffer(offer));
    }
}
