package com.hedspi.ltct.delivery.service;

import com.hedspi.ltct.delivery.entity.Status;
import com.hedspi.ltct.delivery.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAll(){
        return statusRepository.findAll();
    }

    public Status addStatus(Status status){
        return statusRepository.save(status);
    }

    public void deleteStatus(Integer id) {
        Status status = statusRepository.findById(id).get();
        statusRepository.delete(status);
    }

    public Optional<Status> getOne(Integer invalidStatusId) {
        return statusRepository.findById(invalidStatusId);
    }
}
