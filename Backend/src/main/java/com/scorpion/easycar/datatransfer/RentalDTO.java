package com.scorpion.easycar.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentalDTO {
    private String id;
    private String pickupVenue;
    private LocalDate pickupDate;
    private String dropOffVenue;
    private LocalDate dropOffDate;
    private String rentalType;
    private byte[] ldwSlip;
    private String status;
    private CustomerDTO customer;
    private CarDTO car;
    private DriverDTO driver;
}
