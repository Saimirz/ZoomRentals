package com.example.zoomrentals.service;


import com.example.zoomrentals.entity.Account;
import com.example.zoomrentals.exception.ResourceNotFound;
import com.example.zoomrentals.repository.AccountRepository;
import com.example.zoomrentals.request.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(long accountId){
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new ResourceNotFound("Course is not found"));
        return account;
    }

    public Account updateAccount(long accountId, AccountRequest accountRequest){
        if(accountRepository.existsById(accountId))
        {
            Account accountToBeUpdated = new Account(accountRequest);
            accountToBeUpdated.setId(accountId);
            return accountRepository.save(accountToBeUpdated);

        }
        else{
            throw new ResourceNotFound("course is not found");
        }
    }

    public void deleteAccount(long accountId){
        if(accountRepository.existsById(accountId)){
            accountRepository.deleteById(accountId);
        }
        else{
            throw new ResourceNotFound("course is not found");
        }
    }
}
