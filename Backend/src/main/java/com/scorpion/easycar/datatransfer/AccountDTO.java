package com.scorpion.easycar.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AccountDTO {
    private String id;
    private String username;
    private String password;
    private String email;
}
