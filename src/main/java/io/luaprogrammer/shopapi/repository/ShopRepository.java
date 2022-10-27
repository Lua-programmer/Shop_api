package io.luaprogrammer.shopapi.repository;

import io.luaprogrammer.shopapi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> {
}
