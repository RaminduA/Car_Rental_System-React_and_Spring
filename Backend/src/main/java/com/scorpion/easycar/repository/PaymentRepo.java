package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
}
