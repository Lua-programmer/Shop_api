package io.luaprogrammer.shopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItem extends JpaRepository<ShopItem, Long> {
}
