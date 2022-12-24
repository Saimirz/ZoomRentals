package com.example.zoomrentals.response;

import com.example.zoomrentals.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {
    private long id;

    private String accountName;
    private String accountNumber;

    private RenterResponse renter;


    public AccountResponse(Account account){
        id = account.getId();
        accountName = account.getAccountName();
        accountNumber = account.getAccountNumber();

        renter = new RenterResponse(account.getRenter());

    }
}
