package com.revature.RCUbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.RCUbackend.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	public List<Account> findAll();
	
	public List<Account> findByUserId(int id);
	
	@Modifying
	@Query("update Account a SET a.balance = a.balance + :amount WHERE a.accountId = :accountID")
	public void deposit(@Param("amount") int amount, @Param("accountID") int accountID);
	
	@Modifying
	@Query("update Account a SET a.balance = a.balance - :amount WHERE a.accountId = :accountID")
	public void withdraw(@Param("amount") int amount, @Param("accountID") int accountID);
	
	@Modifying
	@Query("update Account a SET a.balance = a.balance + ?1 WHERE a.accountId = ?2")
	public void depositAccount(int amount, int accountID);
	
	@Modifying
	@Query("update Account a SET a.balance = a.balance - ?1 WHERE a.accountId = ?2")
	public void withdrawAccount(int amount, int accountID);
}