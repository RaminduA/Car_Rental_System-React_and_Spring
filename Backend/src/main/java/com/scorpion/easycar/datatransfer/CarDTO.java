package com.scorpion.easycar.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String id;
    private String brand;
    private String carType;
    private String model;
    private int passengerCount;
    private String transmissionType;
    private String fuelType;
    private String colour;
    private byte[] frontView;
    private byte[] rearView;
    private byte[] lateralView;
    private byte[] interiorView;
    private byte[] displayPicture;
    private double dailyRate;
    private double monthlyRate;
    private double distancePerDay;
    private double distancePerMonth;
    private double pricePerExtraKM;
    private double ldw;
    private String status;
}