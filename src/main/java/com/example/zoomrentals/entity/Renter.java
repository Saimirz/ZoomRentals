package com.example.zoomrentals.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "renters")
public class Renter {
    @Id @GeneratedValue
    private long id;
    @Column(name = "first_name")
            private String firstName ;
    @Column (name = "last name")
            private String lastName ;
    @Column (name="email")
            private String email;
    @Column (name = "Number")
             private String number;
    @Column (name = "Address")
             private  String Address;



}
