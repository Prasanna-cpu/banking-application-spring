package com.example.SpringBanker.Banking.repository;

import com.example.SpringBanker.Banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
