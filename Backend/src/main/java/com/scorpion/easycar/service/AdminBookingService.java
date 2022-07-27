package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.DriverDTO;
import com.scorpion.easycar.datatransfer.RentRequestDTO;
import com.scorpion.easycar.datatransfer.RentalDTO;

import java.util.List;

public interface AdminBookingService {
    List<RentRequestDTO> getAllPendingRequests();
    List<String> getAllDriverIds();
    DriverDTO getDriver(String id);
    List<RentalDTO> getDriverScheduleForTheWeek(String id);
    List<RentalDTO> getDriverScheduleForTheMonth(String id);
    void denyRentRequest(String id, String message);
    void acceptRentRequest(String id);
    void acceptRentRequestWithDifferentDriver(String id, String driverId) throws Exception;
}
