package com.hedspi.ltct.delivery.repository;

import com.hedspi.ltct.delivery.model.ShippingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;

public interface ShippingOrderRepository extends JpaRepository<ShippingOrder, Integer> {
    @Query("select count(s.orderCode) from ShippingOrder s where date(s.createAt) = :date")
            long numOfDailyOrders(LocalDate date);
    @Query("select count (s.orderCode) from ShippingOrder s where s.statusCode.id =:statusCode")
    long numOfOrderByStatus(int statusCode);
}