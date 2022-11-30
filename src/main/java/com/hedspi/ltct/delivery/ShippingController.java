package com.example.demo.shipment;

import com.example.demo.Exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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
    public List<Shipping> getShipping() {
        return shippingService.getShipping();
    }

    @GetMapping(path = "/shipment/{shippingId}")
    public Shipping getShipping(@PathVariable("shippingId") Long Id) {
        return shippingService.getShippingbyId(Id);
    }

    @GetMapping
    public Response getOrder() {
        return shippingService.getSorder();
    }

    @GetMapping(path = "{orderId}")
    public Response getOrder(@PathVariable("orderId") Long Id) {
        return shippingService.getSorderbyId(Id);
    }

    @PostMapping
    public Response registerNewShipping(@RequestBody Shipping shipping){
        Sorder sorder = new Sorder(
                ZonedDateTime.now(ZoneId.of("Z")),
                ZonedDateTime.now(ZoneId.of("Z")),
                1,
                "Description",
                "Detail"
        );
        shippingService.addNewSorder(sorder);
        shippingService.addNewShipping(shipping);
        //return shippingService.getShippingbyId(shipping.getId());
        return new Response(new Result(200,"success",true),List.of(sorder));
    }

    @DeleteMapping(path = "{shippingId}")
    public void deleteShipping(@PathVariable("shippingId") Long shippingId){
        shippingService.deleteStudent(shippingId);
    }

    @PutMapping(path = "{orderId}")
    public void updateSorder(@PathVariable("orderId") Long sorderId,
                              @RequestParam(required = false) Integer statuscode,
                              @RequestParam(required = false) String disc,
                              @RequestParam(required = false) String detail){
        shippingService.updateSorder(sorderId, statuscode, disc, detail);
    }

}
