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
public class Payment {
    @Id
    private String id;
    private LocalDate date;
    private String ldwSlip;
    private double expectedCost;
    private double extraMileageCost;
    private double damageCost;
    private double netTotal;

    @OneToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="rentalId", referencedColumnName="id", nullable=false)
    private Rental rental;

    @ManyToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="customerId", referencedColumnName="id", nullable=false)
    private Customer customer;
}
