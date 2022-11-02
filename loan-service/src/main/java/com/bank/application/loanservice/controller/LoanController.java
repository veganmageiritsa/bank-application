package com.bank.application.loanservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.application.loanservice.model.Customer;
import com.bank.application.loanservice.model.Loan;
import com.bank.application.loanservice.repository.LoanRepository;

@RestController
public class LoanController {
private final LoanRepository loanRepository;
    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
    
    public LoanController(final LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    
    @PostMapping("/myLoans")
    public List<Loan> getLoansDetails( @RequestBody Customer customer) {
        logger.info("getLoansDetails() method started");
    
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        
    }
}
