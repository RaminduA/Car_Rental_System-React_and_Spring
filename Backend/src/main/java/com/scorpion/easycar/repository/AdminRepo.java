package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
    Admin findByAccount_Id(String accountId);
}
