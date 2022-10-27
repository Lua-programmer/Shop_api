package io.luaprogrammer.shopapi.entity;

import io.luaprogrammer.shopapi.controller.dto.ShopItemDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "shop_item")
@AllArgsConstructor
@NoArgsConstructor
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_identifier")
    private String productIdentifier;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;

    public static ShopItem convert(ShopItemDTO shopItemDTO) {
        ShopItem shopItem = new ShopItem();
        shopItem.setProductIdentifier(shopItemDTO.getProductIdentifier());
                shopItem.setAmount(shopItemDTO.getAmount());
                shopItem.setPrice(shopItemDTO.getPrice());
        return shopItem;
    }
}
