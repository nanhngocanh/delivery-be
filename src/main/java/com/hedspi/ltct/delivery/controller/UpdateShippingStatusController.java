package com.hedspi.ltct.delivery.controller;

import com.hedspi.ltct.delivery.request.UpdateShippingOrderRequest;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.service.UpdateShippingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UpdateShippingStatusController {
    @Autowired
    UpdateShippingStatusService updateDeleteShippingOrderService;
    @PutMapping(value = "/shipping_order/{orderCode}")
    public CommonResponse updateShipping(@PathVariable String orderCode, @RequestBody UpdateShippingOrderRequest updateShippingOrderRequest){
        return updateDeleteShippingOrderService.updateShipping(orderCode, updateShippingOrderRequest.getStatusCode(), updateShippingOrderRequest.getStatusDetail());
    }
    @DeleteMapping(value = "/shipping_order/{orderCode}")
    public CommonResponse deleteShipping(@PathVariable String orderCode){
        return updateDeleteShippingOrderService.deleteShippingOrder(orderCode);
    }
    @PutMapping(value = "/shipping_order/confirmReceipt/{orderCode}")
    public CommonResponse confirmReceipt(@PathVariable String orderCode){
        return updateDeleteShippingOrderService.confirmReceipt(orderCode);
    }
    @PutMapping(value = "/shipping_order/return/{orderCode}")
    public CommonResponse returnOrder(@PathVariable String orderCode){
        return updateDeleteShippingOrderService.returnOrder(orderCode);
    }
}
