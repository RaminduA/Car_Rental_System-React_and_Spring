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
public class PaymentDTO {
    private String id;
    private LocalDate date;
    private double ldw;
    private double expectedCost;
    private double extraMileageCost;
    private double damageCost;
    private double netTotal;
    private RentalDTO rental;
    private CustomerDTO customer;
}
