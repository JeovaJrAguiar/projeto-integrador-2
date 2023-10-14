package com.back.back.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.repository.CardRepository;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardRepository cardRepository;

    @GetMapping("{id}")
    Optional<Account> 
}
