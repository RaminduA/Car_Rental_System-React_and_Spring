package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepo extends JpaRepository<Rental,String> {
    Rental findTopByOrderByIdDesc();
    List<Rental> findAllByDriverIdAndPickupDateBetween(String driverId, LocalDate pickupDate, LocalDate pickupDate2);
}
