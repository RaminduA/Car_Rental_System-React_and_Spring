package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.CustomerDTO;

public interface LoginRegisterService {
    String loginUser(String username, String password);
    String getCustomerId();
    void registerCustomer(CustomerDTO dto);
}
