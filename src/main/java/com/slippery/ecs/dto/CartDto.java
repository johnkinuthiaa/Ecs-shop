package com.slippery.ecs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.models.User;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto {
    private String message;
    private int statusCode;
    private String errorMessage;
    private User user;
    private List<ShopItem> itemsInCart;
}
