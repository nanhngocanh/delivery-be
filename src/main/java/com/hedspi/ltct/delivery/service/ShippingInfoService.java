package com.hedspi.ltct.delivery.service;

import com.hedspi.ltct.delivery.entity.ShippingOrder;
import com.hedspi.ltct.delivery.repository.ShippingOrderRepository;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.response.OrderStatusResponse;
import com.hedspi.ltct.delivery.response.ShippingFeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingInfoService {
    @Autowired
    ShippingOrderRepository shippingOrderRepository;

    public CommonResponse getAll() {
        CommonResponse commonResponse = new CommonResponse<>();
        try {
            List<ShippingOrder> shippingOrders = shippingOrderRepository.findAll();
            if (shippingOrders == null)
                return commonResponse.result("400", "Yêu cầu không hợp lệ!", false);

            return commonResponse.data(shippingOrders).result("200", "Thành công!", true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500", "Có lỗi server!", false);
        }
    }

    public CommonResponse getById(Integer id) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Optional<ShippingOrder> shippingOrder = shippingOrderRepository.findById(id);
            if (shippingOrder == null)
                return commonResponse.result("400", "Yêu cầu không hợp lệ!", false);
            return commonResponse.data(shippingOrder).result("200", "Thành công!", true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500", "Có lỗi server!", false);
        }
    }

    public CommonResponse getShippingOrderFee(String orderCode) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Optional<ShippingOrder> shippingOrder = shippingOrderRepository.findByOrderCode(orderCode);
            if (shippingOrder == null)
                return commonResponse.result("400", "Yêu cầu không hợp lệ!", false);

            return commonResponse.data(
                    new ShippingFeeResponse(
                            shippingOrder.get().getTotalShippingFee(),
                            shippingOrder.get().getServiceFee(),
                            shippingOrder.get().getInsuranceFee(),
                            shippingOrder.get().getPickStationFee()
                    )
            ).result("200", "Thành công!", true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500", "Có lỗi server!", false);
        }
    }

    public CommonResponse getShippingOrderStatus(String orderCode) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Optional<ShippingOrder> shippingOrder = shippingOrderRepository.findByOrderCode(orderCode);
            if (shippingOrder == null)
                return commonResponse.result("400", "Yêu cầu không hợp lệ!", false);
            return commonResponse.data(
                    new OrderStatusResponse(
                            shippingOrder.get().getStatusCode().getDesc(),
                            shippingOrder.get().getStatusDetail(),
                            shippingOrder.get().getUpdateAt()
                    )
            ).result("200", "Thành công!", true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500", "Có lỗi server!", false);
        }
    }


}
