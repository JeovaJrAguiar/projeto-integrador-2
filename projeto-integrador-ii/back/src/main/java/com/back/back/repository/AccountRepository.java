package com.back.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.back.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    @Query(value = "select * from Account where username = :username", nativeQuery = true)
    Optional<Account> findAccountByUsername(@Param("username") String username);

    @Query(value = "select * from account where mail = :mail", nativeQuery = true)
    Optional<Account> findAccountByMail(@Param("mail") String mail);

    /*
    @Query(value = "select * from user_account where mail != :mail", nativeQuery = true)
    ArrayList<UserAccount> findUsersExceptByMail(String mail);

    @Query(value = "select * from user_account where username like :username%", nativeQuery = true)
    ArrayList<UserAccount> findUsersByUsername(String username);
    */
}
