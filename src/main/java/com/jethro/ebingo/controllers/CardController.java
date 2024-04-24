package com.jethro.ebingo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jethro.ebingo.models.Card;
import com.jethro.ebingo.services.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CardController {
    @Autowired
    CardService service;

    @PostMapping("/getcard")
    public Card createNewCard(@RequestParam int bcode) {
        return service.createNewCard(bcode);
    }

    @GetMapping("/checkwin")
    public int checkCardWin(@RequestParam int card_token) {
        return service.checkWin(card_token);
    }
}
