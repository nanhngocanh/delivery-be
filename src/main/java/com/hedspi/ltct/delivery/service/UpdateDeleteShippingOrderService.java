package com.hedspi.ltct.delivery.service;
import com.hedspi.ltct.delivery.repository.ShippingOrderRepository;
import com.hedspi.ltct.delivery.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDeleteShippingOrderService {
    @Autowired
    ShippingOrderRepository shippingOrderRepository;

    public CommonResponse updateShipping(String orderCode,int statusCode, String statusDetail){
        CommonResponse commonResponse = new CommonResponse<>();
        try {
            Integer updateOk = shippingOrderRepository.updateStatus(orderCode, statusCode, statusDetail);
            if (updateOk.equals(0))
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);

            return commonResponse.result("200","Thành công!",true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500","Có lỗi server!",false);
        }
    }
    public CommonResponse deleteShippingOrder(String orderCode){
        CommonResponse commonResponse = new CommonResponse<>();
        try {

            Integer deleteOk = shippingOrderRepository.deteteShippingOrder(orderCode);
            if (deleteOk.equals(0))
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);

            return commonResponse.result("200","Thành công!",true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500","Có lỗi server!",false);
        }
    }
}
