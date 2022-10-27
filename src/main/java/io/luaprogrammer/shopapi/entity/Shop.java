package io.luaprogrammer.shopapi.entity;

import io.luaprogrammer.shopapi.controller.dto.ShopDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setIdentifier(shopDTO.getIdentifier());
        shop.setDateShop(shopDTO.getDateShop());
        shop.setStatus(shopDTO.getStatus());
        shop.setItems(shopDTO
                .getItems()
                .stream()
                .map(ShopItem::convert)
                .collect(Collectors.toList()));
        return shop;
    }
}
