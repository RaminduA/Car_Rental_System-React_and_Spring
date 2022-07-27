package com.scorpion.easycar.service.impl;

import com.scorpion.easycar.datatransfer.RentalDTO;
import com.scorpion.easycar.repository.RentalRepo;
import com.scorpion.easycar.service.DriverScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
@Transactional
public class DriverScheduleServiceImpl implements DriverScheduleService {

    @Autowired
    private RentalRepo rentalRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RentalDTO> getScheduleForTheWeek(String id) {
        String today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int lastDate = Integer.parseInt(today.split("-")[2]) - LocalDate.now().getDayOfWeek().getValue() + 7;
        String endDate = today.substring(0, today.length()-2) + lastDate;
        return modelMapper.map(rentalRepo.findAllByDriverIdAndPickupDateBetween(id, LocalDate.parse(today, formatter), LocalDate.parse(endDate, formatter)), new TypeToken<List<RentalDTO>>(){}.getType());
    }

    @Override
    public List<RentalDTO> getScheduleForTheMonth(String id) {
        String today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String[] split = today.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int lastDate = YearMonth.of(year, month).lengthOfMonth();
        String endDate = today.substring(0, today.length()-2) + lastDate;
        return modelMapper.map(rentalRepo.findAllByDriverIdAndPickupDateBetween(id, LocalDate.parse(today, formatter), LocalDate.parse(endDate, formatter)), new TypeToken<List<RentalDTO>>(){}.getType());
    }
}
