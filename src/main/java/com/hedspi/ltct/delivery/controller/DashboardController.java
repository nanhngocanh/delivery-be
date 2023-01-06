package com.hedspi.ltct.delivery.controller;

import com.hedspi.ltct.delivery.response.CommonResponse;
import com.hedspi.ltct.delivery.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DashboardController {
    @Autowired
    DashboardService dashboardService;
    @GetMapping (value = "/dashboard")
    public CommonResponse getDashboard(){
        return dashboardService.getDashboard();
    }


}
