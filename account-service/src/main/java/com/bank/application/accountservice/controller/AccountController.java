package com.bank.application.accountservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.application.accountservice.client.CardsFeignClient;
import com.bank.application.accountservice.client.LoansFeignClient;
import com.bank.application.accountservice.model.Account;
import com.bank.application.accountservice.model.Card;
import com.bank.application.accountservice.model.Customer;
import com.bank.application.accountservice.model.CustomerDetails;
import com.bank.application.accountservice.model.Loan;
import com.bank.application.accountservice.repository.AccountRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.annotation.Timed;

@RestController
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    
    private final AccountRepository accountRepository;
    
    private final CardsFeignClient cardsFeignClient;
    
    private final LoansFeignClient loansFeignClient;
    
    public AccountController(
        final AccountRepository accountRepository,
        final CardsFeignClient cardsFeignClient,
        final LoansFeignClient loansFeignClient) {
        this.accountRepository = accountRepository;
        this.cardsFeignClient = cardsFeignClient;
        this.loansFeignClient = loansFeignClient;
    }
    
    
    @PostMapping("/myAccount")
    @Timed(value = "getAccountDetails.time", description = "Time taken to return Account Details")
    public Account getAccountDetails(@RequestBody Customer customer) {
        
        return accountRepository.findByCustomerId(customer.getCustomerId());
        
    }
    
    @PostMapping("/myCustomerDetails")
    @CircuitBreaker(name = "detailsForCustomerSupport", fallbackMethod="myCustomerDetailsFallBack")
    @Retry(name = "retryForCustomerDetails", fallbackMethod = "myCustomerDetailsFallBack")
    public CustomerDetails myCustomerDetails( @RequestBody Customer customer) {
        logger.info("myCustomerDetails() method started");
        Account accounts = accountRepository.findByCustomerId(customer.getCustomerId());
        List<Loan> loans = loansFeignClient.getLoansDetails( customer);
        List<Card> cards = cardsFeignClient.getCardDetails( customer);
        
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        customerDetails.setLoans(loans);
        customerDetails.setCards(cards);
        logger.info("myCustomerDetails() method ended");
        return customerDetails;
    }
    
    private CustomerDetails myCustomerDetailsFallBack( Customer customer, Throwable t) {
       
        Account accounts = accountRepository.findByCustomerId(customer.getCustomerId());
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        return customerDetails;
        
    }
    
}
