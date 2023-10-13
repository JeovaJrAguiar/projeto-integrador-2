package com.back.back.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String mail;
    private String password;
    private String fullName;
    private Double documentNumber;
    private String address;
    @OneToMany(mappedBy = "category")
    private List<Card> cards;
    private Date creationDate;
    private Date deletionDate;

    public Account() {
    }

    public Account(String username, String password, String fullName, Double documentNumber, String address,
            List<Card> cards) {
        long millis = System.currentTimeMillis();  
        Date creationDate =new java.sql.Date(millis);        

        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.documentNumber = documentNumber;
        this.address = address;
        this.cards = cards;
        this.creationDate = creationDate;
        this.deletionDate = null;
    }
    
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public Double getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(Double documentNumber) {
        this.documentNumber = documentNumber;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public List<Card> getCards() {
        return cards;
    }
    public void addCard(Card card) {
        if (this.cards == null) {
            cards = new ArrayList<>();
        }
        this.cards.add(card);
        card.setAccount(this);
    }
    public void setCardsByListCards(List<Card> cards) {
        this.cards = cards;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public Date getDeletionDate() {
        return deletionDate;
    }
    public void setDeletionDate() {
        long millis = System.currentTimeMillis();  
        Date deletionDate =new java.sql.Date(millis);
        
        this.deletionDate = deletionDate;
    }
}
