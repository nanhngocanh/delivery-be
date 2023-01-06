package com.hedspi.ltct.delivery.service;

import com.hedspi.ltct.delivery.repository.ShippingOrderRepository;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.response.DailyOrders;
import com.hedspi.ltct.delivery.response.DashboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {
    @Autowired
    ShippingOrderRepository shippingOrderRepository;

    public CommonResponse getDashboard() {
        CommonResponse commonResponse = new CommonResponse();
        try {
            List<DailyOrders> dailyOrdersList =new ArrayList<DailyOrders>();
            LocalDate curDate = LocalDate.now();
            for(int i=6;i>=0;i--){
                LocalDate tempDate  = curDate.minusDays(i);
                long count = shippingOrderRepository.numOfDailyOrders(tempDate);
                dailyOrdersList.add(new DailyOrders(count,tempDate));
            }
            Map<Integer,Long> numOfOrderStatuses = new HashMap<Integer,Long>();
            long count;
            for(int i = 1;i<=4;i++){
                count = shippingOrderRepository.numOfOrderByStatus(i);
                numOfOrderStatuses.put(i,count);
            }
            DashboardResponse dashboardResponse = new DashboardResponse(dailyOrdersList,numOfOrderStatuses);
            if (dailyOrdersList == null)
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);

            return commonResponse.data(dashboardResponse).result("200","Thành công!",true);
        } catch (Exception e) {

            return commonResponse.result("500","Có lỗi server!",false);
        }
    }
    public CommonResponse getNumOfShippingOrderByStatus(Integer statusCode){
        CommonResponse commonResponse = new CommonResponse();
        try {
            Long count = shippingOrderRepository.numOfOrderByStatus(statusCode);
            if (count == null)
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);

            return commonResponse.data(count).result("200","Thành công!",true);
        } catch (Exception e) {

            return commonResponse.result("500","Có lỗi server!",false);
        }
    }

}