package com.back.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.back.model.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer>{
    @Query(value = "select * from card where cardNumber = :cardnumber", nativeQuery = true)
    Optional<Card> findCardByNumber(@Param("cardnumber") Double cardnumber);

    @Query(value = "select * from card where accountid = :accountid", nativeQuery = true)
    Optional<Card> findCardByAccountId(@Param("accountid") Double accountId);
    
    /*    
    @Query(value = "select * from account where username = :username", nativeQuery = true)
    Optional<Account> findAccountByUsername(String username);

    @Query(value = "select * from account where mail = :mail", nativeQuery = true)
    Optional<Account> findAccountByMail(String mail);
*/
}
