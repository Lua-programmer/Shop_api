package io.luaprogrammer.shopapi.service.impl;

import io.luaprogrammer.shopapi.controller.dto.ShopDTO;
import io.luaprogrammer.shopapi.entity.Shop;
import io.luaprogrammer.shopapi.entity.ShopItem;
import io.luaprogrammer.shopapi.repository.ShopRepository;
import io.luaprogrammer.shopapi.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    public List<ShopDTO> getShop() {
        return shopRepository.findAll().stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    @Override
    public ShopDTO saveShop(ShopDTO shopDTO) {
        shopDTO.setIdentifier(
                UUID.randomUUID().toString());
        shopDTO.setDateShop(LocalDate.now());
        shopDTO.setStatus("PENDING");
        Shop shop = Shop.convert(shopDTO);
        for (ShopItem shopItem : shop.getItems()) {
            shopItem.setShop(shop);
        }
        return ShopDTO.convert(shopRepository.save(shop));
    }
}
