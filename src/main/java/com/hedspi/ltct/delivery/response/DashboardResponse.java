package com.hedspi.ltct.delivery.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DashboardResponse {
    private List<DailyOrders> dailyOrdersList = new ArrayList<DailyOrders>();
    private List<Map<Integer,Long>> numOfOrderStatuses = new ArrayList<Map<Integer, Long>>();

    public DashboardResponse(List<DailyOrders> dailyOrdersList, List<Map<Integer, Long>> numOfOrderStatuses) {
        this.dailyOrdersList = dailyOrdersList;
        this.numOfOrderStatuses = numOfOrderStatuses;
    }

    public List<DailyOrders> getDailyOrdersList() {
        return dailyOrdersList;
    }

    public void setDailyOrdersList(List<DailyOrders> dailyOrdersList) {
        this.dailyOrdersList = dailyOrdersList;
    }

    public List<Map<Integer, Long>> getNumOfOrderStatuses() {
        return numOfOrderStatuses;
    }

    public void setNumOfOrderStatuses(List<Map<Integer, Long>> numOfOrderStatuses) {
        this.numOfOrderStatuses = numOfOrderStatuses;
    }
}
