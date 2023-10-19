package com.back.back.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.model.Card;
import com.back.back.repository.CardRepository;
import com.back.reponse.ApiResponse;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardRepository cardRepository;

    @GetMapping("/{id}")
    Optional<Card> getCardById(@PathVariable("id") Long id){
        return cardRepository.findById(id);
    }

    
    /*@GetMapping("/{id}")
   Optional<Account> getAccountById(@PathVariable("id") Long id){
    return accountRepository.findById(id);
   }*/

    /*@PostMapping()
    public ResponseEntity<ApiResponse> addCard(@RequestBody CardDTO cardDTO){
        
    }*/
}
