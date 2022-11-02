package com.bank.application.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.application.accountservice.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByCustomerId(int customerId);
}
