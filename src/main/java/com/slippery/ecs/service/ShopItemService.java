package com.slippery.ecs.service;

import com.slippery.ecs.dto.ShopItemDto;
import com.slippery.ecs.models.ShopItem;

public interface ShopItemService {
    ShopItemDto createNewItem(ShopItem shopItemDetails);
    ShopItemDto UpdateItem(ShopItem shopItemDetails,Long id);
    ShopItemDto findItemById(Long id);
    ShopItemDto findItemByName(String name);
    ShopItemDto findItemByCategory(String category);
    ShopItemDto findItemByOffer(Boolean offer);
    ShopItemDto getAllItems();
    ShopItemDto deleteItemById(Long id);
    ShopItemDto deleteAllItems();
}
