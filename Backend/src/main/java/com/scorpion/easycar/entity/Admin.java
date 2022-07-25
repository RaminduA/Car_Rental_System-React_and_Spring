package com.scorpion.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admin {
    @Id
    private String id;
    private String name;
    private String email;
    private String contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="accountId", referencedColumnName="id", nullable=false)
    private Account account;
}