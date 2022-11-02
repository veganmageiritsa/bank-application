package com.bank.application.cardservice.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.application.cardservice.model.Card;
import com.bank.application.cardservice.model.Customer;
import com.bank.application.cardservice.repository.CardRepository;

@RestController
public class CardController {
    private static final Logger logger = LoggerFactory.getLogger(CardController.class);
    private final CardRepository cardRepository;
    
    public CardController(final CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    
    @PostMapping("/myCards")
    public List<Card> getCardDetails( @RequestBody Customer customer) {
        logger.info("getCardDetails() method started");
        return cardRepository.findByCustomerId(customer.getCustomerId());
        
    }
}
