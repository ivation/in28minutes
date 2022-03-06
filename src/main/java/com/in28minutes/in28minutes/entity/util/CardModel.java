package com.in28minutes.in28minutes.entity.util;

import com.in28minutes.in28minutes.controller.CardController;
import com.in28minutes.in28minutes.entity.Card;
import lombok.Getter;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
public class CardModel extends EntityModel<Card> {

    private Card card;

    public CardModel(Card card) {
        this.card = card;
        add(linkTo(methodOn(CardController.class).getAll()).withRel("all cards"));
        add(linkTo(methodOn(CardController.class).getByNumber(card.getCardNumber())).withRel("get by card number"));
    }
}
