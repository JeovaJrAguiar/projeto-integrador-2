package com.back.back.rest;

import com.back.back.model.Account;

public class AccountDTO {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String mail;
    private Double documentNumber;
    private String address;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String mail, String password, String username, String fullName, Double documentNumber, String address) {
        this.id = id;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.documentNumber = documentNumber;
        this.address = address;
    }

    public static AccountDTO fromAccount(Account account) {
        return new AccountDTO(
            account.getId(),
            account.getMail(),
            account.getPassword(),
            account.getUsername(),
            account.getFullName(),
            account.getDocumentNumber(),
            account.getAddress()
        );
    }

    public Account toAccount() {
        return new Account( 
            this.username, 
            this.mail, 
            this.password, 
            this.fullName, 
            this.documentNumber,
            this.address
        );
    }

    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getMail() {
        return mail;
    }
    public String getFullName() {
        return fullName;
    }
    public Double getDocumentNumber() {
        return documentNumber;
    }
    public String getAddress() {
        return address;
    }
}
