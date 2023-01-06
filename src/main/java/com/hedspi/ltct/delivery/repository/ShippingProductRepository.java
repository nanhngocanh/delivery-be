package com.hedspi.ltct.delivery.repository;

import com.hedspi.ltct.delivery.entity.ShippingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingProductRepository extends JpaRepository<ShippingProduct, Integer> {
}