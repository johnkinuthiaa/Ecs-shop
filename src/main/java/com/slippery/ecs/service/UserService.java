package com.slippery.ecs.service;


import com.slippery.ecs.dto.UserDto;
import com.slippery.ecs.models.User;

public interface UserService {
    UserDto login(User userDetails);
    UserDto register(User userDetails);
    UserDto deleteAccount(long userId);
    UserDto logOut(User userDetails);
    UserDto findAllUsers();
}
