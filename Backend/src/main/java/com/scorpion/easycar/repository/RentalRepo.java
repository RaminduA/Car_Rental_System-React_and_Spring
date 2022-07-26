package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental,String> {
}
