package io.luaprogrammer.shopapi.controller.dto;

import io.luaprogrammer.shopapi.entity.ShopItem;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShopItemDTO {
    private String productIdentifier;
    private Integer amount;
    private BigDecimal price;

    public static ShopItemDTO convert(ShopItem shopItem) {
        ShopItemDTO shopItemDTO = new ShopItemDTO();
        shopItemDTO.setProductIdentifier(shopItem.getProductIdentifier());
        shopItemDTO.setAmount(shopItem.getAmount());
        shopItemDTO.setPrice(shopItem.getPrice());
        return shopItemDTO;
    }

}
