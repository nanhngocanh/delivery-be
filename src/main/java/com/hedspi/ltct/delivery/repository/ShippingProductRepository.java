package com.hedspi.ltct.delivery.repository;

import com.hedspi.ltct.delivery.entity.ShippingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShippingProductRepository extends JpaRepository<ShippingProduct, Integer> {
    @Query("select p from ShippingProduct p where p.shippingOrder.orderCode = :orderCode")
    List<ShippingProduct> findByShippingOrder(String orderCode);

    @Query("select new com.hedspi.ltct.delivery.entity.ShippingProduct(p.id, p.productId, p.quantity, p.status, p.name, p.color, p.size, p.price) from ShippingProduct p where p.shippingOrder.orderCode = :orderCode")
    List<ShippingProduct> getProductForDisplayByShippingOrder(String orderCode);
}