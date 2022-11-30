package com.hedspi.ltct.delivery.controller;

import com.hedspi.ltct.delivery.request.UpdateShippingOrderRequest;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.service.UpdateDeleteShippingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UpdateDeleteShippingOrderController {
    @Autowired
    UpdateDeleteShippingOrderService updateDeleteShippingOrderService;
    @PutMapping(value = "/shipping_order/cancel/{orderCode}")
    public CommonResponse cancelShipping(@PathVariable String orderCode, @RequestBody UpdateShippingOrderRequest updateShippingOrderRequest){
        return updateDeleteShippingOrderService.updateShipping(orderCode,4, updateShippingOrderRequest.getStatusDetail());
    }
    @PutMapping(value = "/shipping_order/{orderCode}")
    public CommonResponse updateShipping(@PathVariable String orderCode, @RequestBody UpdateShippingOrderRequest updateShippingOrderRequest){
        return updateDeleteShippingOrderService.updateShipping(orderCode, updateShippingOrderRequest.getStatusCode(), updateShippingOrderRequest.getStatusDetail());
    }
    @DeleteMapping(value = "/shipping_order/{orderCode}")
    public CommonResponse deleteShipping(@PathVariable String orderCode){
        return updateDeleteShippingOrderService.deleteShippingOrder(orderCode);
    }
}
