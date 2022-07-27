package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.CarDTO;

import java.util.List;

public interface CustomerCarsService {
    List<CarDTO> getAllCars();
    List<CarDTO> getAllCarsSortedByPassengerCount();
    List<CarDTO> getAllCarsSortedByTransmissionType();
    List<CarDTO> getAllCarsSortedByBrand();
    List<CarDTO> getAllCarsSortedByType();
    List<CarDTO> getAllCarsSortedByPrice();
    List<CarDTO> getAllCarsSortedByFuelType();
}
