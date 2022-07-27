package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRequestRepo extends JpaRepository<RentRequest,String> {
    RentRequest findTopByOrderByIdDesc();

    @Query(value="FROM RentRequest WHERE status='Pending'")
    List<RentRequest> findAllPending();
}
