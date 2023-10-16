package com.back.back.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private MethodEnum method;
    private String description;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Long cardId;
    private Date creationDate;
    private Date deletionDate;
    
    public Transaction() {
    }
    public Transaction(Double value, MethodEnum method, String description, Category category, Long cardId) {
        long millis = System.currentTimeMillis();  
        Date creationDate =new java.sql.Date(millis);  

        this.value = value;
        this.method = method;
        this.description = description;
        this.category = category;
        this.cardId = cardId;
        this.creationDate = creationDate;
        this.deletionDate = null;
    }
    public Long getId() {
        return id;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public MethodEnum getMethod() {
        return method;
    }
    public void setMethod(MethodEnum method) {
        this.method = method;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Long getCardId() {
        return cardId;
    }
    public void setCardId(Long cardId) {
        this.cardId = cardId;
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
