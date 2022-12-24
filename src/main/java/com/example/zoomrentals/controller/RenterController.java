package com.example.zoomrentals.controller;


import com.example.zoomrentals.entity.Renter;
import com.example.zoomrentals.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/renters/")
public class RenterController {

    @Autowired
    RenterService renterService;

    @GetMapping()
    public List<Renter> getAllRenters(){
        return renterService.getAllRenters();
    }
}
