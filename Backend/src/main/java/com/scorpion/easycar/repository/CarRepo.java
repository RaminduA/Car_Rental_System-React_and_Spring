package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CarRepo extends JpaRepository<Car,String> {
    Car findTopByOrderByIdDesc();
    List<Car> findAllByOrderByPassengerCount();
    List<Car> findAllByOrderByTransmissionType();
    List<Car> findAllByOrderByBrand();
    List<Car> findAllByOrderByCarType();
    List<Car> findAllByOrderByDailyRate();
    List<Car> findAllByOrderByFuelType();

    @Query(value = "UPDATE Car SET status=:status WHERE id=:id")
    void updateStatus(@Param("status")String status, @Param("id")String id);

    @Query(value = "UPDATE Car SET frontView=:frontView, rearView=:rearView, lateralView=:lateralView, interiorView=:interiorView, displayPicture=:displayPicture WHERE id=:id")
    void updatePictures(@Param("frontView")String frontView, @Param("rearView")String rearView, @Param("lateralView")String lateralView, @Param("interiorView")String interiorView, @Param("displayPicture")String displayPicture, @Param("id")String id);

    @Query(value = "UPDATE Car SET frontView=:frontView WHERE id=:id")
    void updateFrontView(@Param("frontView")String frontView, @Param("id")String id);

    @Query(value = "UPDATE Car SET rearView=:rearView WHERE id=:id")
    void updateRearView(@Param("rearView")String rearView, @Param("id")String id);

    @Query(value = "UPDATE Car SET lateralView=:lateralView WHERE id=:id")
    void updateLateralView(@Param("lateralView")String lateralView, @Param("id")String id);

    @Query(value = "UPDATE Car SET interiorView=:interiorView WHERE id=:id")
    void updateInteriorView(@Param("interiorView")String interiorView, @Param("id")String id);

    @Query(value = "UPDATE Car SET displayPicture=:displayPicture WHERE id=:id")
    void updateDisplayPicture(@Param("displayPicture")String displayPicture, @Param("id")String id);

    @Query(value = "FROM Car WHERE status=:status")
    List<Car> getAllByStatus(@Param("status")String status);

    @Query(value = "SELECT COUNT(id) FROM Car WHERE status=:status")
    int getCountByStatus(@Param("status")String status);
}