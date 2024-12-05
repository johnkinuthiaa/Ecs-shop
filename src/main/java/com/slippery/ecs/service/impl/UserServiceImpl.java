package com.slippery.ecs.service.impl;

import com.slippery.ecs.dto.UserDto;
import com.slippery.ecs.models.Cart;
import com.slippery.ecs.models.User;
import com.slippery.ecs.repository.CartRepository;
import com.slippery.ecs.repository.UserRepository;
import com.slippery.ecs.service.CartService;
import com.slippery.ecs.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private PasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
    private final UserRepository repository;
    private final CartRepository cartRepository;
    public UserServiceImpl(UserRepository repository, CartRepository cartRepository) {
        this.repository = repository;
        this.cartRepository=cartRepository;
    }

    @Override
    public UserDto login(User userDetails) {
        return null;
    }

    @Override
    public UserDto register(User userDetails) {
        UserDto response =new UserDto();
        if(repository.findUserByUsername(userDetails.getUsername().toLowerCase()) ==null){
            userDetails.setUserPassword(passwordEncoder.encode(userDetails.getUserPassword()));
            userDetails.setUsername(userDetails.getUsername().toLowerCase());
            userDetails.setRole("USER");

            Cart cart =new Cart();
            cart.setUser(userDetails);
            cart.setItems(null);
            userDetails.setCart(cart);
            repository.save(userDetails);

            cartRepository.save(cart);

            response.setMessage("user "+ userDetails.getUsername()+" registered successfully");
            response.setStatusCode(200);
            response.setUser(userDetails);
        }else{
            response.setMessage("user "+ userDetails.getUsername()+" not registered successfully as user with same username already exists");
            response.setStatusCode(200);
        }
        return response;
    }

    @Override
    public UserDto deleteAccount(long userId) {
        UserDto response =new UserDto();
        if(repository.findById(userId).isPresent()){
            repository.deleteById(userId);
            response.setMessage("user account deleted successfully");
            response.setStatusCode(200);
        }else{
            response.setMessage("user account was not found");
            response.setStatusCode(404);
        }
        return response;
    }

    @Override
    public UserDto logOut(User userDetails) {
        return null;
    }

    @Override
    public UserDto findAllUsers() {
        return null;
    }
}
