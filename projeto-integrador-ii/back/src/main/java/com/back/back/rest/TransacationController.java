package com.back.back.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.model.Transaction;
import com.back.back.repository.TransactionRepository;

@RestController
@RequestMapping("/api/transaction")
public class TransacationController {
    @Autowired
    TransactionRepository transacationRepostiory;

    @GetMapping("/{id}")
    Optional<Transaction> getTransacationById(@PathVariable("id") Long id){
        return transacationRepostiory.findById(id);
    }
}
