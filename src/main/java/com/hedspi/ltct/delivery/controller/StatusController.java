package com.hedspi.ltct.delivery.controller;

import com.hedspi.ltct.delivery.entity.Status;
import com.hedspi.ltct.delivery.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusController {
    @Autowired
    StatusService statusService;

    @GetMapping("/status")
    public List<Status> getAll(){
        return statusService.getAll();
    }

    @PostMapping("/status")
    public Status add(@RequestBody Status status){
        return statusService.addStatus(status);
    }

    @DeleteMapping("/status/{id}")
    public void del(@PathVariable("id")Integer id){
        statusService.deleteStatus(id);
    }
}
