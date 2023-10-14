package com.back.back.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double cardNumber;
    private FlagEnum flag;
    private Double dayClose;
    private Boolean isDebit;
    private Boolean isCredit;
    private Double limit;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private Date creationDate;
    private Date deletionDate;

    public Card() {
    }

    public Card(Long id, Double cardNumber, String flag, Double dayClose, Boolean isDebit, Boolean isCredit, Double limit, Long account) {
        // tratar a flat
        // tratar o acconunt
        
        this.id = id;
        this.cardNumber = cardNumber;
        this.flag = flag;
        this.dayClose = dayClose;
        this.isDebit = isDebit;
        this.isCredit = isCredit;
        this.limit = limit;
        this.account = account;
    }

    public Card(FlagEnum flag, Double dayClose, Boolean isDebit, Boolean isCredit, Double limit, Account account) {
        long millis = System.currentTimeMillis();  
        Date creationDate =new java.sql.Date(millis);  

        this.flag = flag;
        this.dayClose = dayClose;
        this.isDebit = isDebit;
        this.isCredit = isCredit;
        this.limit = limit;
        this.account = account;
        this.creationDate = creationDate;
        this.deletionDate = null;
    }

    public Long getId() {
        return id;
    }
    public Double getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Double cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getFlag() {
        return this.flag.toString();
    }

    public void setFlag(FlagEnum flag) {
        this.flag = flag;
    }

    public Double getDayClose() {
        return dayClose;
    }

    public void setDayClose(Double dayClose) {
        this.dayClose = dayClose;
    } 

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(Boolean isCredit) {
        this.isCredit = isCredit;
    }   

    public Boolean getIsDebit() {
        return isDebit;
    }
    
    public void setIsDebit(Boolean isDebit) {
        this.isDebit = isDebit;
    }
    
    public Account getAccount() {
        return this.account;
    }
    public void setAccount(Account account) {
        this.account = account;
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
