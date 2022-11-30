package com.hedspi.ltct.delivery.service;

import com.hedspi.ltct.delivery.exception.ApiRequestException;
import com.hedspi.ltct.delivery.model.Fee;
import com.hedspi.ltct.delivery.model.ShippingOrder;
import com.hedspi.ltct.delivery.model.Status;
import com.hedspi.ltct.delivery.repository.FeeRepository;
import com.hedspi.ltct.delivery.repository.ShippingOrderRepository;
import com.hedspi.ltct.delivery.repository.StatusRepository;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.response.Result;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Stack;

@Service
public class ShippingService {

    @Autowired
    public ShippingService(FeeRepository feeRepository, ShippingOrderRepository shippingOrderRepository, StatusRepository statusRepository) {
        this.feeRepository = feeRepository;
        this.statusRepository = statusRepository;
        this.shippingOrderRepository = shippingOrderRepository;
    }

    private final FeeRepository feeRepository;

    private final StatusRepository statusRepository;
    private final ShippingOrderRepository shippingOrderRepository;

    public List<Fee> getShipping() {
        return feeRepository.findAll();
    }

    //public List<Sorder> getSorder() { return sorderRepository.findAll(); }

    public CommonResponse getSorder() { return new CommonResponse(new Result("200","success",true),shippingOrderRepository.findAll()); }

    public Fee getShippingbyId(Long Id) {
        Fee fee = feeRepository.findById(Id).orElseThrow(() -> new ApiRequestException("(CODE: 400) Shipment with id " + Id + " does not exists"));
        return fee;
    }
    public CommonResponse getSorderbyId(Long Id){
        ShippingOrder shippingOrder = shippingOrderRepository.findById(Id).orElseThrow(() -> new ApiRequestException("(CODE: 400) Order with id " + Id + " does not exists"));
        return new CommonResponse(new Result("200","success",true),List.of(shippingOrder));
    }

    public Status getStatusCodebyId(Integer Id){
        Status status = statusRepository.findById(Id).orElseThrow(() -> new ApiRequestException("(CODE: 400) Order with id " + Id + " does not exists"));
        return status;
    }

    public void addNewShipping(Fee fee){
        feeRepository.save(fee);
        System.out.println(fee);
    }
    public void addNewSorder(ShippingOrder shippingOrder){
        shippingOrderRepository.save(shippingOrder);
        System.out.println(shippingOrder);
    }

    public void deleteStudent(Long Id){
        boolean exists = shippingOrderRepository.existsById(Id);
        if(!exists) {
            throw new ApiRequestException("(CODE: 400) Shipment with id " + Id + " does not exists");
        }
        shippingOrderRepository.deleteById(Id);
    }

    @Transactional
    public void updateSorder(Long Id, Status statuscode, String detail){
        ShippingOrder shippingOrder = shippingOrderRepository.findById(Id).orElseThrow(() -> new IllegalStateException("(CODE: 400) Order with id " + Id + " does not exists"));
        shippingOrder.setStatusCode(statuscode);

        if(detail != null && detail.length() > 0 ){
            shippingOrder.setStatusDetail(detail);
        }
        shippingOrder.setUpdateAt(Instant.now());

    }
}
