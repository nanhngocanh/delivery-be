package com.hedspi.ltct.delivery.service;

import com.hedspi.ltct.delivery.entity.ShippingOrder;
import com.hedspi.ltct.delivery.entity.ShippingProduct;
import com.hedspi.ltct.delivery.repository.ShippingOrderRepository;
import com.hedspi.ltct.delivery.repository.ShippingProductRepository;
import com.hedspi.ltct.delivery.repository.StatusRepository;
import com.hedspi.ltct.delivery.request.ShippingFeeRequest;
import com.hedspi.ltct.delivery.request.createRequest.CreateShippingOrderRequest;
import com.hedspi.ltct.delivery.request.createRequest.Product;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.response.ShippingFeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateUpdateShippingOrderService {
    @Autowired
    private ShippingOrderRepository shippingOrderRepository;
    @Autowired
    private ShippingProductRepository shippingProductRepository;
    @Autowired
    private ShippingFeeService shippingFeeService;

    @Autowired
    private StatusRepository statusRepository;

    public CommonResponse createShippingOrder(CreateShippingOrderRequest createShippingOrderRequest){
        CommonResponse commonResponse = new CommonResponse<>();
        try {
            ShippingFeeResponse shippingFee = shippingFeeService.getFeeFromGhn(new ShippingFeeRequest(
//                    createShippingOrderRequest.getWarehouse().getAddress().getDistrict(),
                    1488,
                    createShippingOrderRequest.getReceiver().getAddress().getDistrict(),
                    createShippingOrderRequest.getReceiver().getAddress().getWard(),
                    createShippingOrderRequest.getCod()
            ));
            if (shippingFee == null)
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);

            ShippingOrder shippingOrder = new ShippingOrder(
                    createShippingOrderRequest.getOrderId(),
                    shippingFee.getServiceFee(),
                    shippingFee.getInsuranceFee(),
                    shippingFee.getPickStationFee(),
                    shippingFee.getTotalFee(),
                    createShippingOrderRequest.getWarehouse().getAddress().getWard().toString(),
                    createShippingOrderRequest.getWarehouse().getAddress().getDistrict().toString(),
                    createShippingOrderRequest.getWarehouse().getAddress().getProvince().toString(),
                    createShippingOrderRequest.getWarehouse().getAddress().getDetail(),
                    createShippingOrderRequest.getReceiver().getName(),
                    createShippingOrderRequest.getReceiver().getPhone(),
                    createShippingOrderRequest.getReceiver().getAddress().getWard().toString(),
                    createShippingOrderRequest.getReceiver().getAddress().getDistrict().toString(),
                    createShippingOrderRequest.getReceiver().getAddress().getProvince().toString(),
                    createShippingOrderRequest.getReceiver().getAddress().getDetail(),
                    createShippingOrderRequest.getCod(),
                    createShippingOrderRequest.getWeight()
            );
            shippingOrder.setStatusCode(statusRepository.findById(1).get());
            ShippingOrder newShippingOrder = shippingOrderRepository.save(shippingOrder);
            if (newShippingOrder == null)
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);

            List<ShippingProduct> shippingProductList = new ArrayList<>();
            for (Product product : createShippingOrderRequest.getProducts()) {
                shippingProductList.add(new ShippingProduct(
                        newShippingOrder,
                        product.getId(),
                        product.getQuantity(),
                        product.getName(),
                        product.getColor(),
                        product.getSize(),
                        product.getPrice()));
            }

            List<ShippingProduct> newShippingProduct = shippingProductRepository.saveAll(shippingProductList);
            if (newShippingProduct == null || newShippingProduct.size() < 1)
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);
            return commonResponse.result("200","Thành công!",true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500","Có lỗi server!",false);
        }
    }

    public CommonResponse redeliver(String orderCode, CreateShippingOrderRequest createShippingOrderRequest){
        CommonResponse commonResponse = new CommonResponse<>();
        try {
            Integer updateOk = shippingOrderRepository.updateStatus(orderCode, 5, "Đang lấy lại hàng từ phía khách hàng");
            if (updateOk.equals(0))
                return commonResponse.result("400","Yêu cầu không hợp lệ! Mã đơn hàng không tồn tại",false);
            List<ShippingProduct> oldShippingProduct = shippingProductRepository.findByShippingOrder(orderCode);
            if (oldShippingProduct == null || oldShippingProduct.isEmpty())
                return commonResponse.result("400","Yêu cầu không hợp lệ! Mã đơn hàng không tồn tại",false);
            for (ShippingProduct shippingProduct : oldShippingProduct) {
                shippingProduct.setStatus(0);
            }
            List<ShippingProduct> updatedOldShippingProduct = shippingProductRepository.saveAll(oldShippingProduct);
            if (updatedOldShippingProduct == null || updatedOldShippingProduct.isEmpty())
                return commonResponse.result("400","Yêu cầu không hợp lệ! Không thể cập nhật sản phẩm trong đơn hàng",false);
            List<ShippingProduct> newShippingProduct = new ArrayList<>();
            for (Product product : createShippingOrderRequest.getProducts()) {
                newShippingProduct.add(new ShippingProduct(
                        shippingOrderRepository.findByOrderCode(orderCode).get(),
                        product.getId(),
                        product.getQuantity(),
                        product.getName(),
                        product.getColor(),
                        product.getSize(),
                        product.getPrice())
                );
            }
            List<ShippingProduct> insertedNewShippingProduct = shippingProductRepository.saveAll(newShippingProduct);
            if (insertedNewShippingProduct == null || insertedNewShippingProduct.isEmpty())
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);
            return commonResponse.result("200","Thành công!",true);
        } catch (Exception e) {
            System.out.println(e);
            return commonResponse.result("500","Có lỗi server!",false);
        }
    }
}
