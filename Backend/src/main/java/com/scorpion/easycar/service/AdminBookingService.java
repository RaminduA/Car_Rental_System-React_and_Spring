package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.DriverDTO;
import com.scorpion.easycar.datatransfer.RentRequestDTO;
import com.scorpion.easycar.datatransfer.RentResponseDTO;
import com.scorpion.easycar.datatransfer.RentalDTO;

import java.util.List;

public interface AdminBookingService {
    List<RentRequestDTO> getAllPendingRequests();
    List<String> getAllDriverIds();
    DriverDTO getDriver(String id);
    String getResponseId();
    String getRentalId();
    List<RentalDTO> getDriverScheduleForTheWeek(String id);
    List<RentalDTO> getDriverScheduleForTheMonth(String id);
    void denyRentRequest(RentResponseDTO dto);
    void acceptRentRequest(RentResponseDTO dto);
    void acceptRentRequestWithDifferentDriver(RentResponseDTO dto, String driverId) throws Exception;
}
