package com.scorpion.easycar.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String displayPicture;
    private String nicFrontImage;
    private String nicRearImage;
    private String licenceImage;
    private String status;
    private AccountDTO account;
}
