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
	/**
     * This method retrieves all Accounts from the database
     * This method can be removed in favor of the built-in findAll method
     * that comes with extending JpaRepository
     * @return the list of Account objects
	 */
	public List<Account> findAll();
	
	/**
	 * This method finds the Accounts by the desired userID
	 * @param id the int representing the userID of the account
	 * @return the list of Account objects of the desired userID
	 */
	public List<Account> findByUserId(int id);
	
	/**
	 * This method modifies an Account object's balance by performing
	 * addition on said balance and updating it to the database.
	 * @param amount the int that indicates how much will be added on to
	 * the Account object's balance
	 * @param accountID the int representing the accountID of the account
	 */
	@Modifying
	@Query("update Account a SET a.balance = a.balance + :amount WHERE a.accountId = :accountID")
	public void deposit(@Param("amount") int amount, @Param("accountID") int accountID);
	
	/**
	 * This method modifies an Account object's balance by performing
	 * subtraction on said balance and updating it to the database.
	 * @param amount the int that indicates how much will be subtracted on to
	 * the Account object's balance
	 * @param accountID the int representing the accountID of the account
	 */
	@Modifying
	@Query("update Account a SET a.balance = a.balance - :amount WHERE a.accountId = :accountID")
	public void withdraw(@Param("amount") int amount, @Param("accountID") int accountID);
	
	/**
	 * This method modifies an Account object's balance by performing
	 * addition on said balance and updating it to the database.
	 * 
	 * This method can be removed in favor of the deposit() method, however, the 
	 * transfer() method in the TransactionController class would have to be
	 * refactored accordingly. This method was kept in order for the project
	 * to compile.
	 * @param amount the int that indicates how much will be added on to
	 * the Account object's balance
	 * @param accountID the int representing the accountID of the account
	 */
	@Modifying
	@Query("update Account a SET a.balance = a.balance + ?1 WHERE a.accountId = ?2")
	public void depositAccount(int amount, int accountID);
	
	/**
	 * This method modifies an Account object's balance by performing
	 * subtraction on said balance and updating it to the database.
	 * 
	 * This method can be removed in favor of the withdraw() method, however, the 
	 * transfer() method in the TransactionController class would have to be
	 * refactored accordingly. This method was kept in order for the project
	 * to compile.
	 * @param amount the int that indicates how much will be subtracted on to
	 * the Account object's balance
	 * @param accountID the int representing the accountID of the account
	 */
	@Modifying
	@Query("update Account a SET a.balance = a.balance - ?1 WHERE a.accountId = ?2")
	public void withdrawAccount(int amount, int accountID);
}