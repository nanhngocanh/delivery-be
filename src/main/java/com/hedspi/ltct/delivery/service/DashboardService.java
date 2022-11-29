package com.hedspi.ltct.delivery.service;

import com.hedspi.ltct.delivery.repository.ShippingOrderRepository;
import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.response.DailyOrders;
import com.hedspi.ltct.delivery.response.DashboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {
    @Autowired
    ShippingOrderRepository shippingOrderRepository;

    public CommonResponse getDailyOrders() {
        CommonResponse commonResponse = new CommonResponse();

        try {
            List<DailyOrders> dailyOrdersList =new ArrayList<DailyOrders>();
            LocalDate curDate = LocalDate.now();
            for(int i=6;i>=0;i--){
                LocalDate tempDate  = curDate.minusDays(i);
                long count = shippingOrderRepository.numOfDailyOrders(tempDate);
                dailyOrdersList.add(new DailyOrders(count,tempDate));
            }

            List<Map<Integer,Long>> numOfOrderStatuses = new ArrayList<Map<Integer,Long>>();

            for(int i = 1;i<=4;i++){
                long count = shippingOrderRepository.numOfOrderByStatus(i);


            }
            DashboardResponse dashboardResponse = new DashboardResponse(dailyOrdersList,);



            if (dailyOrdersList == null)
                return commonResponse.result("400","Yêu cầu không hợp lệ!",false);

            return commonResponse.data(dashboardResponse).result("200","Thành công!",true);
        } catch (Exception e) {

            return commonResponse.result("500","Có lỗi server!",false);
        }
    }


}