package com.example.zoomrentals.controller;


import com.example.zoomrentals.entity.Account;
import com.example.zoomrentals.entity.Renter;
import com.example.zoomrentals.request.AccountRequest;
import com.example.zoomrentals.request.RenterRequest;
import com.example.zoomrentals.response.AccountResponse;
import com.example.zoomrentals.response.RenterResponse;
import com.example.zoomrentals.service.RenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/renters/")
public class RenterController {

    @Autowired
    RenterService renterService;

    @GetMapping()
    public List<RenterResponse> getAllRenters(@RequestParam(required = false) String firstName){
        List<Renter> renters = renterService.getAllRenters(firstName);

        List<RenterResponse> renterResponses = new ArrayList<>();

        renters.forEach(renter -> {renterResponses.add(new RenterResponse(renter));
        });

        return renterResponses;

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)

    public RenterResponse addRenter( @Valid @RequestBody RenterRequest renterRequest){

        Renter renter = renterService.insertRenter(renterRequest);
        return new RenterResponse(renter);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{renter_id}/accounts")
    public AccountResponse addAccount(@PathVariable long renterId, @Valid @RequestBody AccountRequest accountRequest)
    {
        return new AccountResponse(renterService.addAccountToRenter(renterId , accountRequest));
    }

    @GetMapping("/{renter_id}/accounts")
        public List<AccountResponse> getAllAccounts(@PathVariable long renter_id){
        List<Account> accounts = renterService.getAllAccounts(renter_id);
        List<AccountResponse> accountResponses = new ArrayList<>();
        for(int i = 0; i <accounts.size(); i++){
            accountResponses.add(new AccountResponse(accounts.get(i)));
        }
                return accountResponses;
        }


    @PutMapping("/{id}")

    public RenterResponse updateRenter(@PathVariable long id ,
                                         @Valid @RequestBody RenterRequest renterRequest){

        Renter updatedRenter = renterService.updateRenter(id,renterRequest);

        return new RenterResponse(updatedRenter);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable long id)
    {
        renterService.deleteRenter(id);
    }


}
