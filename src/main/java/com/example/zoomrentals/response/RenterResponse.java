package com.example.zoomrentals.response;

import com.example.zoomrentals.entity.Renter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RenterResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String number;

    private CarResponse car;

    public  RenterResponse(Renter renter){
        id = renter.getId();
        firstName = renter.getFirstName();
        lastName = renter.getLastName();
        email = renter.getEmail();
        number  = renter.getNumber();
        car = new CarResponse(renter.getCar());


    }
}
