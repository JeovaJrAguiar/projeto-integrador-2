package com.back.back.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.back.back.model.Category;
import com.back.back.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
    Optional<Category> findById(Long transactionId);
    // Optional<Category> findById(Long categoryId);
}
