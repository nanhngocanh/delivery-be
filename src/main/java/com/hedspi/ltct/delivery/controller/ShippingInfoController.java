package com.hedspi.ltct.delivery.controller;

import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.service.ShippingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShippingInfoController {
    @Autowired
    private ShippingInfoService shippingInfoService;

    @GetMapping("/shipping_order/status/{orderCode}")
    public CommonResponse getShippingOrderStatus(@PathVariable String orderCode){
        return shippingInfoService.getShippingOrderStatus(orderCode);
    }

    @GetMapping("/shipping_order/fee/{orderCode}")
    public CommonResponse getShippingOrderFee(@PathVariable String orderCode){
        return shippingInfoService.getShippingOrderFee(orderCode);
    }
}
