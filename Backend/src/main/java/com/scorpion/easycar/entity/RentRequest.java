package com.scorpion.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RentRequest {
    @Id
    private String id;
    private String pickupVenue;
    private LocalDate pickupDate;
    private String dropOffVenue;
    private LocalDate dropOffDate;
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
