package com.example.zoomrentals.controller;


import com.example.zoomrentals.entity.Renter;
import com.example.zoomrentals.request.RenterRequest;
import com.example.zoomrentals.response.RenterResponse;
import com.example.zoomrentals.service.RenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/renters/")
public class RenterController {

    @Autowired
    RenterService renterService;

    @GetMapping()
    public List<RenterResponse> getAllRenters(){
        List<Renter> renters = renterService.getAllRenters();

        List<RenterResponse> renterResponses = new ArrayList<>();

        renters.forEach(renter -> {renterResponses.add(new RenterResponse(renter));
        });

        return renterResponses;

    }

    @PostMapping()

    public RenterResponse addRenter( @Valid @RequestBody RenterRequest renterRequest){

        Renter renter = renterService.insertRenter(renterRequest);
        return new RenterResponse(renter);

    }
}
