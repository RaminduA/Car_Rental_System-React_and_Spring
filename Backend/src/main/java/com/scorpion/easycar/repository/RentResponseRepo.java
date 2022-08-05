package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Customer;
import com.scorpion.easycar.entity.RentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentResponseRepo extends JpaRepository<RentResponse,String> {
    RentResponse findTopByOrderByIdDesc();

    @Query(value="FROM RentResponse WHERE status IN ('Accepted','Denied') AND customer.id=:customerId")
    List<RentResponse> findAllUnseenResponsesByCustomerId(@Param("customerId") String customerId);

    @Query(value="UPDATE RentResponse SET status='Seen' WHERE id=:id")
    void makeResponseSeen(@Param("id") String id);
}
