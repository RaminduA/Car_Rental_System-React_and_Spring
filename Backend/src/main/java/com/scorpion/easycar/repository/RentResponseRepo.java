package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Customer;
import com.scorpion.easycar.entity.RentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentResponseRepo extends JpaRepository<RentResponse,String> {
    RentResponse findTopByOrderByIdDesc();

    @Query(value="FROM RentResponse WHERE customer=:customer")
    List<RentResponse> findAllUnseenResponsesByCustomer(@Param("customer") Customer customer);
}
