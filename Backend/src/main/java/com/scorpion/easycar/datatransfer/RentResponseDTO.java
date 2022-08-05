package com.scorpion.easycar.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentResponseDTO {
    private String id;
    private String message;
    private String status;
    private RentRequestDTO rentRequest;
    private CustomerDTO customer;
}
