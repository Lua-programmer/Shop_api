package io.luaprogrammer.shopapi.service;

import io.luaprogrammer.shopapi.controller.dto.ShopDTO;

import java.util.List;

public interface ShopService {
    List<ShopDTO> getShop();
    ShopDTO saveShop(ShopDTO shopDTO);
}
