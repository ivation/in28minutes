package com.in28minutes.in28minutes.controller;

import com.in28minutes.in28minutes.entity.Card;
import com.in28minutes.in28minutes.entity.util.CardModel;
import com.in28minutes.in28minutes.repository.CardRepository;
import com.in28minutes.in28minutes.util.CardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/")
    public ResponseEntity<List<CardModel>> getAll() {
        return ResponseEntity.ok(
                cardRepository.findAll().stream()
                        .map(CardModel::new)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<CardModel> getByNumber(@PathVariable String cardNumber) {
        return ResponseEntity.ok(
                Optional.of(cardRepository.findByCardNumber(cardNumber))
                        .map(CardModel::new)
                        .orElseThrow(() -> new CardNotFoundException(cardNumber))
        );
    }

    @PostMapping("/")
    public ResponseEntity<CardModel> save(@RequestBody Card card) {
        return ResponseEntity.ok(
                Optional.of(cardRepository.save(card))
                        .map(CardModel::new)
                        .get()
        );
    }

    @PutMapping("/")
    public ResponseEntity<CardModel> update(@RequestBody Card card) {
        return ResponseEntity.ok(
                Optional.of(cardRepository.save(card))
                        .map(CardModel::new)
                        .get()
        );
    }

    @DeleteMapping("/{cardNumber}")
    public ResponseEntity<?> deleteCard(@PathVariable String cardNumber) {
        cardRepository.delete(cardRepository.findByCardNumber(cardNumber));
//        cardRepository.deleteByCardNumber(cardNumber);
        return ResponseEntity.ok(String.format("Card with number %s has been deleted.", cardNumber));
    }
}
