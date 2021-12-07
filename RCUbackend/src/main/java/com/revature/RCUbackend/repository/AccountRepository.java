package com.revature.RCUbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.RCUbackend.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	public List<Account> findAll();
	
	@Modifying
	@Query("update Account a SET a.balance = a.balance + ?1 WHERE a.accountId = ?2")
	public void depositAccount(int amount, int accountID);
	
	@Modifying
	@Query("update Account a SET a.balance = a.balance - ?1 WHERE a.accountId = ?2")
	public void withdrawAccount(int amount, int accountID);
}
