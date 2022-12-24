package com.example.zoomrentals.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequest {

    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String type;
    @NotBlank
    private String year;
}
