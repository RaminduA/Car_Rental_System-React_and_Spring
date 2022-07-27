package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.CustomerDTO;

public interface CustomerProfileService {
    void updateDisplayPicture(byte[] displayPicture, String id);
    void updatePersonalDetails(CustomerDTO dto);
}
