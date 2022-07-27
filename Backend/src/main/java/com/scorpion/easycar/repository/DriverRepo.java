package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Driver findByAccount_Id(String accountId);
    Driver findTopByOrderByIdDesc();

    @Query(value="SELECT id FROM Driver")
    List<String> getAllIds();

    @Query(value = "UPDATE Driver SET status=:status WHERE id=:id")
    void updateStatus(@Param("status")String status, @Param("id")String id);

    @Query(value = "FROM Driver WHERE status='Available'")
    List<Driver> getAllAvailableDrivers();

    @Query(value = "SELECT COUNT(id) FROM Driver WHERE status=:status")
    int getCountByStatus(@Param("status")String status);
}