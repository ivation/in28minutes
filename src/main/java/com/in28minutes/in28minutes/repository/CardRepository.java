package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, String> {
    List<Card> findAll();

    Card findByCardNumber(String cardNumber);

    Card save(Card card);

    void deleteByCardNumber(String cardNumber);
}
