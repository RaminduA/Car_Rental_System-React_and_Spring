package com.scorpion.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RentResponse {
    @Id
    private String id;
    private String message;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="requestId", referencedColumnName="id", nullable=false)
    private RentRequest rentRequest;

    @ManyToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="customerId", referencedColumnName="id", nullable=false)
    private Customer customer;
}
