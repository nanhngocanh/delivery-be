package com.hedspi.ltct.delivery.controller;

import com.hedspi.ltct.delivery.model.Fee;
import com.hedspi.ltct.delivery.model.ShippingOrder;
import com.hedspi.ltct.delivery.model.Status;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.response.Result;
import com.hedspi.ltct.delivery.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService studentService) {

        this.shippingService = studentService;
    }

    @GetMapping(path = "/shipment")
    public List<Fee> getShipping() {
        return shippingService.getShipping();
    }

    @GetMapping(path = "/shipment/{shippingId}")
    public Fee getShipping(@PathVariable("shippingId") Long Id) {
        return shippingService.getShippingbyId(Id);
    }

    @GetMapping
    public CommonResponse getOrder() {
        return shippingService.getSorder();
    }

    @GetMapping(path = "{orderId}")
    public CommonResponse getOrder(@PathVariable("orderId") Long Id) {
        return shippingService.getSorderbyId(Id);
    }

    @PostMapping
    public CommonResponse registerNewShipping(@RequestBody Fee fee){
        ShippingOrder shippingorder = new ShippingOrder(
                "OD" + (int) ((Math.random() * (999 - 100)) + 100),
                shippingService.getStatusCodebyId(1),
                "Description",
                Instant.now(),
                Instant.now()
        );
        shippingService.addNewSorder(shippingorder);
        shippingService.addNewShipping(fee);
        return new CommonResponse(new Result("200","success",true),List.of(shippingorder));
    }

    @DeleteMapping(path = "{shippingId}")
    public void deleteShipping(@PathVariable("shippingId") Long shippingId){
        shippingService.deleteStudent(shippingId);
    }

//    @PutMapping(path = "{orderId}")
//    public void updateSorder(@PathVariable("orderId") Long sorderId,
//                              @RequestParam(required = false) Status statuscode,
//                              @RequestParam(required = false) String disc,
//                              @RequestParam(required = false) String detail){
//        shippingService.updateSorder(sorderId, statuscode, disc, detail);
//    }

}
