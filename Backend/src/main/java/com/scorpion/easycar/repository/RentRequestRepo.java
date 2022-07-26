package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRequestRepo extends JpaRepository<RentRequest,String> {
}
