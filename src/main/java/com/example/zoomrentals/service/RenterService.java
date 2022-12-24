package com.example.zoomrentals.service;

import com.example.zoomrentals.entity.Renter;
import com.example.zoomrentals.repository.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterService {
    @Autowired
    RenterRepository renterRepository;

    public List<Renter> getAllRenters(){

        return (List<Renter>) renterRepository.findAll();
    }
}
