
package com.revature.RCUbackend.repositories;

import com.revature.RCUbackend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

package com.revature.RCUbackend.repositories;

import com.revature.RCUbackend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

