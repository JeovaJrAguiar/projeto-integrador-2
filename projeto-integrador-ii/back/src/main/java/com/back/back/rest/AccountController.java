package com.back.back.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.model.Account;
import com.back.back.repository.AccountRepository;

@RestController
@RequestMapping("/api/account")
public class AccountController {
   @Autowired
   AccountRepository accountRepository;
   
   @GetMapping("/{id}")
   Optional<Account> getAccountById(@PathVariable("id") Long id){
    return accountRepository.findById(id);
   }

   @PostMapping()
   AccountDTO addAccount(@RequestBody AccountDTO accountDTO){
        Optional<Account> accountOpt = accountRepository.findAccountByMail(accountDTO.getMail());
        Account account = new Account(
            accountDTO.getUsername(),
            accountDTO.getMail(),
            accountDTO.getPassword(),
            accountDTO.getFullName(),
            accountDTO.getDocumentNumber(),
            accountDTO.getAddress()
        );

        if(accountOpt == null){
            accountRepository.save(account);
            return accountDTO;
        }else {
            return null;
        }
   }
}
