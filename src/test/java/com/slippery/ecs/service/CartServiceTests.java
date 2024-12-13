package com.slippery.ecs.service;

import com.slippery.ecs.dto.CartDto;
import com.slippery.ecs.models.Cart;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.repository.CartRepository;
import com.slippery.ecs.repository.UserRepository;
import com.slippery.ecs.service.impl.CartServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartServiceTests {
    @Mock
    private CartRepository repository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private CartServiceImpl service;



//    @Test
//    public void cartCreationTest(){
//        Cart cart =Cart.builder()
//                .user(userRepository.findById(1L).get())
//                .build();
//        when(repository.save(Mockito.any(Cart.class))).thenReturn(Optional.ofNullable(cart));
//        CartDto response =service.addItemToCart(1L,userRepository.findById(1L).get().getId(),1L);
//        Assertions.assertThat(response.getErrorMessage()).isNull();
//    }
}
