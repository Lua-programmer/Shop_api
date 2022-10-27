package io.luaprogrammer.shopapi.controller;

import io.luaprogrammer.shopapi.controller.dto.ShopDTO;
import io.luaprogrammer.shopapi.service.impl.ShopServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopServiceImpl shopService;

    @GetMapping
    public List<ShopDTO> getShop() {
        return shopService.getShop();
    }

    @PostMapping
    public ShopDTO saveShop(@RequestBody ShopDTO shopDTO) {
        return shopService.saveShop(shopDTO);
    }
}
