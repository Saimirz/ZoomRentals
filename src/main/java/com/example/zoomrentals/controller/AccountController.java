package com.example.zoomrentals.controller;

import com.example.zoomrentals.request.AccountRequest;
import com.example.zoomrentals.response.AccountResponse;
import com.example.zoomrentals.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;



    @GetMapping("/{accountId}")

    public AccountResponse getAccount(@PathVariable long accountId){

        return new AccountResponse(accountService.getAccount(accountId));

    }

    @PutMapping("/{accountId}")

    public AccountResponse updateAccount(@PathVariable long accountId, @Valid  @RequestBody AccountRequest accountRequest){

        return new AccountResponse(accountService.updateAccount(accountId,accountRequest));


    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable long accountId){

        accountService.deleteAccount(accountId);

    }
}
