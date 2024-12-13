package com.slippery.ecs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.slippery.ecs.models.ShopItem;
import jakarta.persistence.Lob;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopItemDto {
    private int statusCode;
    private String message;
    private String errorMessage;
    private ShopItem item;
    List<ShopItem> shopItemList;
}
