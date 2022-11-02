package com.bank.application.cardservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.application.cardservice.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByCustomerId(int customerId);
}
