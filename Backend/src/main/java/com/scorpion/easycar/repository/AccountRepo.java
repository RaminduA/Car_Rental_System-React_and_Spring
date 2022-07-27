package com.scorpion.easycar.repository;

import com.scorpion.easycar.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepo extends JpaRepository<Account,String> {
    Account findTopByOrderByIdDesc();
    Account findByUsernameAndPassword(String username, String password);
    Account findByEmailAndPassword(String email, String password);
}
