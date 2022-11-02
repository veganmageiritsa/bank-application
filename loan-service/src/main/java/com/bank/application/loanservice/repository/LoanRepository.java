package com.bank.application.loanservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.application.loanservice.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    
    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
}
