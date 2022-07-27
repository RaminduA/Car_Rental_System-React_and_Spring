package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.RentalDTO;

import java.util.List;

public interface DriverScheduleService {
    List<RentalDTO> getScheduleForTheWeek(String id);
    List<RentalDTO> getScheduleForTheMonth(String id);
}
