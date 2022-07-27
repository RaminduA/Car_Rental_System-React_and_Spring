package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.DriverDTO;

import java.util.List;

public interface AdminDriversService {
    DriverDTO getDriver(String id);
    List<DriverDTO> getAllDrivers();
    void saveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    void deleteDriver(String id);
    DriverDTO getDriverByAccountId(String accountId);
    void updateStatus(String status, String id);
    List<DriverDTO> getAllAvailable();
    int getCountByStatus(String status);
}
