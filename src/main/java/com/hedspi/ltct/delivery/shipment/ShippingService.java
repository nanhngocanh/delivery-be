package com.example.demo.shipment;

import com.example.demo.Exception.ApiRequestException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ShippingService {

    @Autowired
    public ShippingService(ShippingRepository shippingRepository,SorderRepository sorderRepository) {
        this.shippingRepository = shippingRepository;
        this.sorderRepository = sorderRepository;
    }

    private final ShippingRepository shippingRepository;
    private final SorderRepository sorderRepository;
    public List<Shipping> getShipping() {
        return shippingRepository.findAll();
    }

    //public List<Sorder> getSorder() { return sorderRepository.findAll(); }

    public Response getSorder() { return new Response(new Result(200,"success",true),sorderRepository.findAll()); }

    public Shipping getShippingbyId(Long Id) {
        Shipping shipping = shippingRepository.findById(Id).orElseThrow(() -> new ApiRequestException("(CODE: 400) Shipment with id " + Id + " does not exists"));
        return shipping;
    }
    public Response getSorderbyId(Long Id){
        Sorder sorder = sorderRepository.findById(Id).orElseThrow(() -> new ApiRequestException("(CODE: 400) Order with id " + Id + " does not exists"));
        return new Response(new Result(200,"success",true),List.of(sorder));
    }

    public void addNewShipping(Shipping shipping){
        shippingRepository.save(shipping);
        System.out.println(shipping);
    }
    public void addNewSorder(Sorder sorder){
        sorderRepository.save(sorder);
        System.out.println(sorder);
    }

    public void deleteStudent(Long Id){
        boolean exists = shippingRepository.existsById(Id);
        if(!exists) {
            throw new ApiRequestException("(CODE: 400) Shipment with id " + Id + " does not exists");
        }
        shippingRepository.deleteById(Id);
    }

    @Transactional
    public void updateSorder(Long Id,Integer statuscode,String disc,String detail){
        Sorder sorder = sorderRepository.findById(Id).orElseThrow(() -> new IllegalStateException("(CODE: 400) Order with id " + Id + " does not exists"));
        sorder.setStatusCode(statuscode);

        if(disc != null && disc.length() > 0 ){
            sorder.setStatusDesc(disc);
        }

        if(detail != null && detail.length() > 0 ){
            sorder.setStatusDetail(detail);
        }
        sorder.setUpdateAt(ZonedDateTime.now(ZoneId.of("Z")));

    }
}
