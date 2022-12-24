package com.example.zoomrentals.entity;

import com.example.zoomrentals.request.AccountRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String accountNumber;

    private String accountName;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "renter_id")
    private Renter renter;

    public Account (AccountRequest accountRequest){
        accountName = accountRequest.getAccountName();
        accountNumber = accountRequest.getAccountNumber();
    }

}
