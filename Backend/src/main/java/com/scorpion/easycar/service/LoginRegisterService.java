package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.CustomerDTO;

public interface LoginRegisterService {
    String loginUser(String username, String password);
    String getCustomerId();
    String getAccountId();
    void registerCustomer(CustomerDTO dto);
}
