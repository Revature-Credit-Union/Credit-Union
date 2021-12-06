package com.revature.RCUbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.RCUbackend.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	@Modifying
	@Query("update Account a SET a.balance = a.balance + :amount WHERE a.accountID = :accountID")
	public void depositAccount(@Param("amount") int amount, @Param("accountID") int accountID);
	
	@Modifying
	@Query("update Account a SET a.balance = a.balance - :amount WHERE a.accountID = :accountID")
	public void withdrawAccount(@Param("amount") int amount, @Param("accountID") int accountID);
}
