package com.example.zoomrentals.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "renters")
public class Renter {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
            private String firstName ;
    @Column (name = "last name")
            private String lastName ;
    @Column (name="email")
            private String email;
    @Column (name = "number")
             private String number;
    @Column (name = "address")
             private  String address;




}
