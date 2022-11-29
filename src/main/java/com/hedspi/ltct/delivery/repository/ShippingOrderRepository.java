package com.hedspi.ltct.delivery.repository;

import com.hedspi.ltct.delivery.model.ShippingOrder;
import com.hedspi.ltct.delivery.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface ShippingOrderRepository extends JpaRepository<ShippingOrder, Integer> {
    @Query("select count(s.orderCode) from ShippingOrder s where date(s.createAt) = :date")
    long numOfDailyOrders(LocalDate date);
    @Query("select count (s.orderCode) from ShippingOrder s where s.statusCode.id =:statusCode")
    long numOfOrderByStatus(int statusCode);
    @Transactional
    @Modifying
    @Query(value = "update shipping_order set status_code = :statusCode, status_detail = :statusDetail where order_code = :orderCode",nativeQuery = true)
    Integer updateStatus(String orderCode, int statusCode, String statusDetail);
    @Transactional
    @Modifying
    @Query(value = "delete from shipping_order where order_code = :orderCode",nativeQuery = true)
    Integer deteteShippingOrder(String orderCode);
}