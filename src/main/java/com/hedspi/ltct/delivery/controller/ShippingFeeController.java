package com.hedspi.ltct.delivery.controller;

import com.hedspi.ltct.delivery.request.ShippingFeeRequest;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.service.ShippingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShippingFeeController {
    @Autowired
    private ShippingFeeService shippingFeeService;

    @PostMapping("/shipping_fee")
    public CommonResponse caculateShippingFee(@RequestBody ShippingFeeRequest shippingFeeRequest){
        return shippingFeeService.caculateShippingFee(shippingFeeRequest);
    }
}
