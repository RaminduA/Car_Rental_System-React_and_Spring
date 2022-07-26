package com.scorpion.easycar.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AdminDTO {
    private String id;
    private String name;
    private String email;
    private String contact;
    private AccountDTO account;
}