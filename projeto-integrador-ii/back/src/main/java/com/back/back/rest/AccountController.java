package com.back.back.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.model.Account;
import com.back.back.repository.AccountRepository;
import com.back.reponse.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/account")
public class AccountController {
   @Autowired
   AccountRepository accountRepository;
   ApiResponse apiResponse = new ApiResponse();

   @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String mail, @RequestHeader HttpHeaders headers){
        String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
        
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic")) {
            String credentials = authorizationHeader.substring("Basic ".length()).trim();
            
            String decodedCredentials = new String(java.util.Base64.getDecoder().decode(credentials));

            String[] userAndPassword = decodedCredentials.split(":");
            String mailFromHeader = userAndPassword[0];

            // Agora você pode comparar o mail obtido do cabeçalho com o mail da solicitação
            if (mail.equals(mailFromHeader)) {
                // Autenticação bem-sucedida
                return new ResponseEntity<>("Usuário autenticado com sucesso", HttpStatus.OK);
            }
        }

        // Se as credenciais não corresponderem, retorne um erro de autenticação
        return new ResponseEntity<>("Falha na autenticação", HttpStatus.UNAUTHORIZED);
    }


   @GetMapping("/{id}")
   Optional<Account> getAccountById(@PathVariable("id") Long id){
    return accountRepository.findById(id); 
    //Optional<Account> accountOpt = accountRepository.findById(id);

    /*if(accountOpt.isEmpty()){
        apiResponse.setBadRequest("Email not found.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    } else {
        return accountOpt;
    }*/
   }

    /*
   @GetMapping("/{id}")
   public ResponseEntity<ApiResponse> getAccountById(@PathVariable("id") Long id){
        Optional<Account> accountOpt = accountRepository.findById(id);
        ApiResponse apiResponse = new ApiResponse();

        if(accountOpt.isPresent()){
            Account account = accountOpt.get();
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> accountMap = new HashMap<>();

            accountMap.put("id", account.getId());
            accountMap.put("username", account.getUsername());
            accountMap.put("mail", account.getMail());
            accountMap.put("fullName", account.getFullName());
            accountMap.put("documentNumber", account.getDocumentNumber());
            accountMap.put("cards", account.getCards());
            accountMap.put("creationDate", account.getCreationDate());
            accountMap.put("deletionDate", account.getDeletionDate());

            String accountJson;
            try {
                accountJson = objectMapper.writeValueAsString(accountMap);
            } catch (JsonProcessingException e) {
                apiResponse.setServerError("Error serializing Account object.");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
            }
            apiResponse.setSuccess(accountJson);
            return ResponseEntity.ok(apiResponse);
        }else {
            apiResponse.setBadRequest("Id not found.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }
   }*/
   @GetMapping("/byMailAndPassword")
   Optional<Account> getAccountByMailAndPassword(@RequestBody AccountDTO accountDTO){
    return accountRepository.findAccountByMailAndPassword(accountDTO.getMail(), accountDTO.getPassword());
   }

   @GetMapping("/me")
   Optional<Account> getUserByIdAndPassword(@PathVariable String me){
        String credentials[] = new String[2];
       credentials = me.split(":");
       return accountRepository.findAccountByMailAndPassword(credentials[0], credentials[1]);
   }


   @PostMapping()
   public ResponseEntity<ApiResponse> addAccount(@RequestBody AccountDTO accountDTO){
        Optional<Account> accountOpt = accountRepository.findAccountByMail(accountDTO.getMail());
        
        if(accountOpt.isEmpty()){
            Account account = new Account(
                accountDTO.getUsername(),
                accountDTO.getMail(),
                accountDTO.getPassword(),
                accountDTO.getFullName(),
                accountDTO.getDocumentNumber(),
                accountDTO.getAddress()
            );

            accountRepository.save(account);
            apiResponse.setSuccess("Created with sucess.");
            return ResponseEntity.ok(apiResponse);
        }else {
            apiResponse.setBadRequest("Email already registered.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }
   }

   @GetMapping("/login/{mail}/{password}")
    Optional<Account> getAccountById(@PathVariable("mail") String mail, @PathVariable("password") String password){
        return accountRepository.findByMailAndPassword(mail, password);
    }
}
