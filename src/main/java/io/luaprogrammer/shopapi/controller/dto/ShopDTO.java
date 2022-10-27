package io.luaprogrammer.shopapi.controller.dto;

import io.luaprogrammer.shopapi.entity.Shop;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ShopDTO {
    private String identifier;
    private LocalDate dateShop;
    private String status;
    private List<ShopItemDTO> items = new ArrayList<>();

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setIdentifier(shop.getIdentifier());
        shopDTO.setDateShop(shop.getDateShop());
        shopDTO.setStatus(shop.getStatus());
        shopDTO.setItems(shop
                .getItems()
                .stream()
                .map(ShopItemDTO::convert)
                .collect(Collectors.toList()));
        return shopDTO;
    }
}
