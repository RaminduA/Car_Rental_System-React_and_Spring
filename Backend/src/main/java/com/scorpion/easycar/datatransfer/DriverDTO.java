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
    private byte[] displayPicture;
    private byte[] nicFrontImage;
    private byte[] nicRearImage;
    private byte[] licenceImage;
    private String status;
    private AccountDTO account;
}
