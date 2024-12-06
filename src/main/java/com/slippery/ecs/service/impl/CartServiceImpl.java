package com.slippery.ecs.service.impl;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.repository.CartRepository;
import com.slippery.ecs.repository.ShopItemRepository;
import com.slippery.ecs.repository.UserRepository;
import com.slippery.ecs.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository repository;
    private final UserRepository userRepository;
    private final ShopItemRepository shopItemRepository;

    public CartServiceImpl(CartRepository repository, UserRepository userRepository, ShopItemRepository shopItemRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.shopItemRepository = shopItemRepository;
    }


    @Override
    public CartDto getCartById(Long id) {
        CartDto response =new CartDto();
        if(repository.findById(id).isPresent()){
            var cart =repository.findById(id).orElseThrow();
            response.setCart(cart);
            response.setMessage("cart with id "+id +".");
            response.setStatusCode(200);
        }else{
            response.setMessage("cart with id "+id +"not found");
            response.setStatusCode(200);
        }
        return response;
    }

    @Override
    public CartDto updateCart(Cart cartDetails, Long id) {
        return null;
    }

    @Override
    public CartDto addItemToCart(ShopItem item, long userId,long cartId) {
        CartDto response =new CartDto();
        Cart cart =repository.findById(cartId).orElseThrow();
        if(cart !=null){
            cart.getItems().add(item);
            item.getCart().add(cart);
            repository.save(cart);
            response.setMessage("item successfully added in cart! ");
            response.setStatusCode(200);
        }else{
            response.setMessage("item not added in cart! ");
            response.setStatusCode(404);
        }

        return response;
    }
    @Override
    public CartDto clearCart(Long cartId) {
        CartDto response =new CartDto();
        Cart cart =repository.findById(cartId).orElseThrow();
        if(cart !=null){
            cart.getItems().clear();
            System.out.println("items deleted");
            repository.save(cart);
            response.setMessage("all items in cart cleared");
            response.setStatusCode(200);
        }else{
            response.setMessage("cart not cleared ");
            response.setStatusCode(404);
        }

        return response;
    }
}
