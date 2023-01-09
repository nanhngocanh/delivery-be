package com.hedspi.ltct.delivery.service;

import com.hedspi.ltct.delivery.request.GhnRequest;
import com.hedspi.ltct.delivery.request.ShippingFeeRequest;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.response.GhnResponse;
import com.hedspi.ltct.delivery.response.ShippingFeeResponse;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Service
public class ShippingFeeService {
    public CommonResponse caculateShippingFee(ShippingFeeRequest shippingFeeRequest){
        CommonResponse commonResponse = new CommonResponse<>();
        try {
            ShippingFeeResponse shippingFee = getFeeFromGhn(shippingFeeRequest);

            if (shippingFee == null)
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);

            return commonResponse.data(shippingFee).result("200","Thành công!",true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500","Có lỗi server!",false);
        }
    }

    public ShippingFeeResponse getFeeFromGhn(ShippingFeeRequest shippingFeeRequest){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", "11802752-8ab4-11ed-b190-ea4934f9883e");
        httpHeaders.add("ShopId","3501897 - 0868856227");
        HttpEntity<GhnRequest> header = new HttpEntity<>(
                new GhnRequest(
                        shippingFeeRequest.getFrom_district_id(),
                        shippingFeeRequest.getTo_district_id(),
                        shippingFeeRequest.getTo_ward_code(),
                        shippingFeeRequest.getCod_value()
                ), httpHeaders);
        ResponseEntity<GhnResponse> response = restTemplate
                .exchange("https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/fee", HttpMethod.POST, header, GhnResponse.class);
        return  new ShippingFeeResponse(
                response.getBody().getData().getTotal() + (int)Math.floor(shippingFeeRequest.getCod_value()/10.0),
                response.getBody().getData().getService_fee() + (int)Math.floor(shippingFeeRequest.getCod_value()/10.0),
                response.getBody().getData().getInsurance_fee(),
                response.getBody().getData().getPick_station_fee()
        );
    }
}
