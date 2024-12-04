package com.slippery.ecs.service.impl;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.repository.CartRepository;
import com.slippery.ecs.repository.UserRepository;
import com.slippery.ecs.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository repository;
    private final UserRepository userRepository;

    public CartServiceImpl(CartRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public CartDto createNewCart(Cart cartDetails,Long userId) {
        CartDto response =new CartDto();
        try{
            cartDetails.setItemsInCart(null);
            cartDetails.setUser(userRepository.findById(userId).orElseThrow());
            repository.save(cartDetails);
        } catch (RuntimeException e) {
            response.setErrorMessage(e.getMessage());
        }
        return null;
    }

    @Override
    public CartDto updateCart(Cart cartDetails, Long id) {
        return null;
    }

    @Override
    public CartDto addItemToCart(ShopItem item, long userId,long cartId) {
        CartDto response =new CartDto();
        Optional<Cart> cartToAddItems =repository.findById(cartId);
        if(cartToAddItems.isPresent()){
            Cart update =cartToAddItems.get();
            List<ShopItem> name =new ArrayList<>();
            name.add(item);
            update.setItemsInCart(name);
            repository.save(update);
            response.setMessage("item successfully added in cart! ");
            response.setStatusCode(200);
        }else{
            response.setMessage("item not added in cart! ");
            response.setStatusCode(404);
        }

        return response;
    }
    @Override
    public CartDto clearCart(long id) {
        CartDto response =new CartDto();

        return null;
    }
}
