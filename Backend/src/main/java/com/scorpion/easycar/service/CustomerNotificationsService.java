package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.RentResponseDTO;

import java.util.List;

public interface CustomerNotificationsService {
    List<RentResponseDTO> getAllUnseenResponses(String customerId);
    void makeResponseSeen(String id);
}
