package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.CustomerDTO;

import java.util.List;

public interface AdminCustomersService {
    CustomerDTO getCustomer(String id);
    List<CustomerDTO> getAllCustomers();
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
}
