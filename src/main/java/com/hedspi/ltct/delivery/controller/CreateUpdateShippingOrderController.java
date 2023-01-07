package com.hedspi.ltct.delivery.controller;

import com.hedspi.ltct.delivery.request.createRequest.CreateShippingOrderRequest;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.service.CreateUpdateShippingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CreateUpdateShippingOrderController {
    @Autowired
    private CreateUpdateShippingOrderService createUpdateShippingOrderService;

    @PostMapping("/shipping_order")
    public CommonResponse createShipping(@RequestBody CreateShippingOrderRequest createShippingOrderRequest){
        return createUpdateShippingOrderService.createShippingOrder(createShippingOrderRequest);
    }
    @PutMapping("/shipping_order/redeliver/{orderCode}")
    public CommonResponse redeliver(@PathVariable("orderCode")String orderCode, @RequestBody CreateShippingOrderRequest createShippingOrderRequest){
        return createUpdateShippingOrderService.redeliver(orderCode, createShippingOrderRequest);
    }
}
