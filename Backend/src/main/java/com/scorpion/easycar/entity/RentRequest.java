package com.scorpion.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RentRequest {
    @Id
    private String id;
    private String customerId;
    private String carId;
    private String driverId;
    private String pickupVenue;
    private String pickupDate;
    private String dropOffVenue;
    private String dropOffDate;
    private String rentalType;
    private String ldwSlip;
    private String status;

    @ManyToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="customerId", referencedColumnName="id", nullable=false)
    private Customer customer;

    @ManyToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="carId", referencedColumnName="id", nullable=false)
    private Car car;

    @ManyToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="driverId", referencedColumnName="id", nullable=false)
    private Driver driver;
}
