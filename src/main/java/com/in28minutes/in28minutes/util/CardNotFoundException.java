package com.in28minutes.in28minutes.util;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String cardNumber) {
        super(String.format("Card with number %s can't be found.", cardNumber));
    }
}
