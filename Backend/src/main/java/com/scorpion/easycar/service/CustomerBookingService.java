package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.RentRequestDTO;

public interface CustomerBookingService {
    void requestCarBooking(RentRequestDTO dto);
    String getRequestId();
}
