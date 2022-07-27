package com.scorpion.easycar.service;

import com.scorpion.easycar.datatransfer.CarDTO;

import java.util.List;

public interface AdminCarsService {
    CarDTO getCar(String id);
    List<CarDTO> getAllCars();
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String id);
    void updateStatus(String status, String id);
    List<CarDTO> getAllByStatus(String status);
    int getCountByStatus(String status);
    void updatePictures(byte[] frontView, byte[] rearView, byte[] lateralView, byte[] interiorView, byte[] displayPicture, String id);
    void updateFrontView(byte[] frontView, String id);
    void updateRearView(byte[] rearView, String id);
    void updateLateralView(byte[] lateralView, String id);
    void updateInteriorView(byte[] interiorView, String id);
    void updateDisplayPicture(byte[] displayPicture, String id);
}
