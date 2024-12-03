package com.slippery.ecs.repository;

import com.slippery.ecs.models.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopItemRepository extends JpaRepository<ShopItem,Long> {
}
