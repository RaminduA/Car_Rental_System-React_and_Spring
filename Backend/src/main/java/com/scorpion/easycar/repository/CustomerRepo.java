package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findByAccount_Id(String accountId);
    Customer findTopByOrderByIdDesc();

    @Query(value="UPDATE Customer SET displayPicture=:displayPicture WHERE id=:id")
    void updateDisplayPicture(@Param("displayPicture")String displayPicture, @Param("id")String id);
}
