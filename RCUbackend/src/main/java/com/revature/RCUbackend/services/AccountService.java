package com.revature.RCUbackend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.repositories.AccountRepository;

@Service
@Transactional
public class AccountService {
	private AccountRepository accountRepository;
	
	/**
	 * The constructor for the AccountService class
	 * @param accountRepository the AccountRepository instance used to
	 * access the repository layer of the application
	 */
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	/**
	 * This method retrieves all Accounts from the database
	 * @return the list of Account objects found by the repository; may be empty
	 */
	public List<Account> findAll() {
		return this.accountRepository.findAll();
	}
	
	/**
	 * This method finds the Accounts by the desired userID
	 * @param id the int representing the userID of the account
	 * @return the list of Account objects found by the repository; may be empty
	 */
	public List<Account> findByUserId(int id) {
		return this.accountRepository.findByUserId(id);
	}
	
	/**
	 * This method modifies an Account object's balance by performing
	 * addition on said balance and updating it to the database.
	 * @param amount the int that indicates how much will be added on to
	 * the Account object's balance
	 * @param accountID the int representing the accountID of the account
	 */
	public void deposit(int amount, int accountID) {
		this.accountRepository.deposit(amount, accountID);
	}
	
	/**
	 * This method modifies an Account object's balance by performing
	 * subtraction on said balance and updating it to the database.
	 * @param amount the int that indicates how much will be subtracted on to
	 * the Account object's balance
	 * @param accountID the int representing the accountID of the account
	 */
	public void withdraw(int amount, int accountID) {
		this.accountRepository.withdraw(amount, accountID);
	}
	
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
	public void depositAccount(int amount, Account account) {
		this.accountRepository.depositAccount(amount, account.getAccountId());
	}
	
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
	public void withdrawAccount(int amount, Account account) {
		this.accountRepository.withdrawAccount(amount, account.getAccountId());
	}
	/*
	public boolean create(int id) {
		Account account = new Account();
		account.setAccountId(id);
		return this.accountRepository.p
	}*/
	
}
