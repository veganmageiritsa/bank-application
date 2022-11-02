package com.bank.application.loanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class LoanServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LoanServiceApplication.class, args);
    }
    
}
