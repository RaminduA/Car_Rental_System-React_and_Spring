package com.scorpion.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Driver {
    @Id
    private String id;
    private String name;
    private String address;
    private String contact;
    private String displayPicture;
    private String nicFrontImage;
    private String nicRearImage;
    private String licenceImage;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="accountId", referencedColumnName="id", nullable=false)
    private Account account;
}
