package com.example.zoomrentals.response;

import com.example.zoomrentals.entity.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {
    private String brand;
    private String model;
    private String year;
    private String type;

    public CarResponse (Car car){
        brand = car.getBrand();
        model = car.getModel();
        year = car.getYear();
        type = car.getType();
    }
}
