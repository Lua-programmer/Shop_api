package io.luaprogrammer.shopapi.repository;

import io.luaprogrammer.shopapi.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
}
