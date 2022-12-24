package com.example.zoomrentals.service;

import com.example.zoomrentals.entity.Account;
import com.example.zoomrentals.entity.Renter;
import com.example.zoomrentals.exception.ResourceNotFound;
import com.example.zoomrentals.repository.AccountRepository;
import com.example.zoomrentals.repository.RenterRepository;
import com.example.zoomrentals.request.AccountRequest;
import com.example.zoomrentals.request.RenterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterService {
    @Autowired
    RenterRepository renterRepository;

    @Autowired
    AccountRepository accountRepository;

    public List<Renter> getAllRenters(String firstNameParam){

        if(firstNameParam == null || firstNameParam.isBlank())
            return (List<Renter>) renterRepository.findAll();


        return renterRepository.findAllByFirstNameIgnoreCase(firstNameParam);


    }

    public Renter insertRenter(RenterRequest renterRequest){

        return renterRepository.save(new Renter(renterRequest));

    }

    public Renter updateRenter(long renterId, RenterRequest renterRequest){

        renterRepository.findById(renterId)
                .orElseThrow(()->new ResourceNotFound("Teacher id is now found"));

        Renter renterToBeUpdated = new Renter(renterRequest);
        renterToBeUpdated.setId(renterId);

        return renterRepository.save(renterToBeUpdated);
    }

    public void deleteRenter(long renterId){

        if (renterRepository.existsById(renterId)) {
            renterRepository.deleteById(renterId);
        }
        else{
            throw new ResourceNotFound("teacher id not found");
        }


    }
    public Account addAccountToRenter(long renterId, AccountRequest accountRequest){
        Renter renter = renterRepository.findById(renterId)
                .orElseThrow(()-> new ResourceNotFound("Teacher not found"));
        Account accountToBeAdded = new Account(accountRequest);
        accountToBeAdded.setRenter(renter);
        return accountRepository.save(accountToBeAdded);
    }

    public List<Account> getAllAccounts(long renter_id){
        return accountRepository.findAllByRenterId(renter_id);
    }

}
