package com.hedspi.ltct.delivery.response;

import java.util.*;

public class DashboardResponse {
    private List<DailyOrders> orderQuantityPerDay = new ArrayList<DailyOrders>();
    private Map<Integer,Long> orderQuantityByStatus = new HashMap<Integer,Long>();

    public DashboardResponse(List<DailyOrders> orderQuantityPerDay, Map<Integer, Long> orderQuantityByStatus) {
        this.orderQuantityPerDay = orderQuantityPerDay;
        this.orderQuantityByStatus = orderQuantityByStatus;
    }

    public List<DailyOrders> getOrderQuantityPerDay() {
        return orderQuantityPerDay;
    }

    public void setOrderQuantityPerDay(List<DailyOrders> orderQuantityPerDay) {
        this.orderQuantityPerDay = orderQuantityPerDay;
    }

    public Map<Integer, Long> getOrderQuantityByStatus() {
        return orderQuantityByStatus;
    }

    public void setOrderQuantityByStatus(Map<Integer, Long> orderQuantityByStatus) {
        this.orderQuantityByStatus = orderQuantityByStatus;
    }
}
