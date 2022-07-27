package com.scorpion.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
    private String id;
    private String brand;
    private String carType;
    private String model;
    private int passengerCount;
    private String transmissionType;
    private String fuelType;
    private String colour;
    private String frontView;
    private String rearView;
    private String lateralView;
    private String interiorView;
    private String displayPicture;
    private double lastMaintenance;
    private double dailyRate;
    private double monthlyRate;
    private double distancePerDay;
    private double distancePerMonth;
    private double pricePerExtraKM;
    private double ldw;
    private String status;
}