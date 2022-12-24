package com.example.zoomrentals.service;

import com.example.zoomrentals.entity.Renter;
import com.example.zoomrentals.repository.RenterRepository;
import com.example.zoomrentals.request.RenterRequest;
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

    public Renter insertRenter(RenterRequest renterRequest){

        return renterRepository.save(new Renter(renterRequest));

    }
}
