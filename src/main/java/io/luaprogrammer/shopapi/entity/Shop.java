package io.luaprogrammer.shopapi.entity;

import io.luaprogrammer.shopapi.controller.dto.ShopItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "shop")
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identifier;

    private String status;

    @Column(name = "date_shop")
    private LocalDate dateShop;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "shop")
    private List<ShopItem> items;

    public static ShopItem convert(ShopItemDTO shopItemDTO) {
        ShopItem shopItem = new ShopItem();
        shopItem.setProductIdentifier(shopItemDTO.getProductIdentifier());
                shopItem.setAmount(shopItemDTO.getAmount());
                shopItem.setPrice(shopItemDTO.getPrice());
        return shopItem;
    }
}
