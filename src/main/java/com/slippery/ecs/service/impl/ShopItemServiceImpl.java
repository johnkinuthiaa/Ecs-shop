package com.slippery.ecs.service.impl;

import com.slippery.ecs.dto.ShopItemDto;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.repository.ShopItemRepository;
import com.slippery.ecs.service.ShopItemService;
import jakarta.persistence.Lob;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopItemServiceImpl implements ShopItemService {
    private final ShopItemRepository repository;

    public ShopItemServiceImpl(ShopItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShopItemDto createNewItem(ShopItem shopItemDetails) {
        ShopItemDto response =new ShopItemDto();
        repository.save(shopItemDetails);
        response.setMessage("item "+ shopItemDetails.getName()+" was created successfully");
        response.setStatusCode(200);
        response.setItem(shopItemDetails);
        return response;
    }

    @Override
    public ShopItemDto UpdateItem(ShopItem shopItemDetails,Long id) {
        ShopItemDto response =new ShopItemDto();
        Optional<ShopItem> existingItem =repository.findById(id);
        if(existingItem.isPresent()){
            ShopItem updatedItem =existingItem.get();
            updatedItem.setName(shopItemDetails.getName());
            updatedItem.setImages(shopItemDetails.getImages());
            updatedItem.setPrice(shopItemDetails.getPrice());
            updatedItem.setDescription(shopItemDetails.getDescription());
            updatedItem.setOffer(shopItemDetails.getOffer());
            updatedItem.setOfferAmount(shopItemDetails.getOfferAmount());
            updatedItem.setCategory(shopItemDetails.getCategory());
            updatedItem.setQuantity(shopItemDetails.getQuantity());
            updatedItem.setStatus(shopItemDetails.getStatus());
            repository.save(updatedItem);
            response.setMessage("item with id "+id+" updated successfully");
            response.setStatusCode(200);
        }else{
            response.setErrorMessage("item with id "+id+" not updated successfully because it does not exist");
            response.setStatusCode(404);
        }
        return response;
    }

    @Override
    public ShopItemDto findItemById(Long id) {
        ShopItemDto response =new ShopItemDto();
        ShopItem item =repository.findById(id).orElseThrow(() ->new RuntimeException("item not found"));
        response.setItem(item);
        response.setStatusCode(200);
        return response;
    }

    @Override
    public ShopItemDto findItemByName(String name) {
        ShopItemDto response =new ShopItemDto();
        List<ShopItem> itemByName =repository.findAll().stream()
                .filter(shopItem -> shopItem.getName().toLowerCase().equals(name.toLowerCase()))
                .toList();
        if(!itemByName.isEmpty()){
            response.setMessage("items with the name "+name);
            response.setStatusCode(200);
            response.setShopItemList(itemByName);
        }else{
            response.setErrorMessage("items with the name "+name+" not found!!");
            response.setStatusCode(200);
        }
        return response;
    }

    @Override
    public ShopItemDto findItemByCategory(String category) {
        ShopItemDto response =new ShopItemDto();
        List<ShopItem> itemByCategory =repository.findAll().stream()
                .filter(shopItem -> shopItem.getCategory().toLowerCase().equals(category.toLowerCase()))
                .toList();
        if(!itemByCategory.isEmpty()){
            response.setMessage("items with the category "+category);
            response.setStatusCode(200);
            response.setShopItemList(itemByCategory);
        }else{
            response.setErrorMessage("items with the name "+category+" not found!!");
            response.setStatusCode(200);
        }
        return response;
    }

    @Override
    public ShopItemDto findItemByOffer(Boolean offer) {
        ShopItemDto response =new ShopItemDto();
        List<ShopItem> hasOffer =repository.findAll().stream()
                .filter(shopItem -> shopItem.getOffer().equals(offer))
                .toList();
        if(!hasOffer.isEmpty()){
            response.setMessage("items with offer status "+offer);
            response.setStatusCode(200);
            response.setShopItemList(hasOffer);
        }else{
            response.setErrorMessage("items with offer status "+offer+" not found");
            response.setStatusCode(200);
        }
        return response;
    }

    @Override
    public ShopItemDto getAllItems() {
        ShopItemDto response =new ShopItemDto();
        if(!repository.findAll().isEmpty()){
            response.setShopItemList(repository.findAll());
            response.setMessage("all items in store");
            response.setStatusCode(200);
        }else{
            response.setMessage("shop is empty");
            response.setStatusCode(404);
        }
        return response;
    }

    @Override
    public ShopItemDto deleteItemById(Long id) {
        ShopItemDto response =new ShopItemDto();
        Optional<ShopItem> existingItem =repository.findById(id);
        if(existingItem.isPresent()){
            repository.deleteById(id);
            response.setMessage("item with id "+id+" deleted ");
            response.setStatusCode(200);
            response.setItem(repository.findById(id).orElseThrow());
        }else{
            response.setErrorMessage("item with id "+id+" was not found ");
            response.setStatusCode(200);

        }
        return response;
    }

    @Override
    public ShopItemDto deleteAllItems() {
        return null;
    }
}
