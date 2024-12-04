package com.slippery.ecs.repository;

import com.slippery.ecs.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
