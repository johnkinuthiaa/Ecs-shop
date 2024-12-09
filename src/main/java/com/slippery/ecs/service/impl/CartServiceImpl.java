package com.slippery.ecs.service.impl;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.models.User;
import com.slippery.ecs.repository.CartRepository;
import com.slippery.ecs.repository.ShopItemRepository;
import com.slippery.ecs.repository.UserRepository;
import com.slippery.ecs.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository repository;
    private final UserRepository userRepository;
    private final ShopItemRepository shopItemRepository;
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository repository, UserRepository userRepository, ShopItemRepository shopItemRepository, CartRepository cartRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.shopItemRepository = shopItemRepository;
        this.cartRepository = cartRepository;
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
    public CartDto addItemToCart(Long itemId, Long UserId,Long cartId) {
        CartDto response =new CartDto();
        ShopItem product = shopItemRepository.findById(itemId).get();
        User user =userRepository.findById(UserId).get();
        Cart cart =cartRepository.findById(cartId).get();


        if(product !=null && user !=null){
            cart.setUser(user);
            cart.getItems().add(product);
            cartRepository.save(cart);
            response.setMessage("item added to cart");
            response.setStatusCode(200);
        }else{
            response.setMessage("item not added to cart");
            response.setStatusCode(200);
        }

        return response;
    }
    @Override
    public CartDto clearCart(Long cartId) {
        CartDto response =new CartDto();
        Cart cart =cartRepository.findById(cartId).orElseThrow();
        if(cart !=null){
            cart.getItems().clear();
            cartRepository.save(cart);
            response.setMessage("cleared your cart");
            response.setStatusCode(200);
        }else{
            response.setMessage("items not cleared from cart");
            response.setStatusCode(200);
        }

        return response;
    }
}
