
package com.revature.RCUbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.services.AccountService;

@RestController("accountController")
@RequestMapping("/account") 
@CrossOrigin(origins="*")
public class AccountController {
	private AccountService accountService;
	
	/**
	 * The constructor for the AccountController class
	 * @param accountService the AccountService instance used to
	 * access the service layer of the application
	 */
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	/**
	 * This method finds all of the Accounts.
	 * @return the list of Account objects found ; may be empty
	 */
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> findAll(){
		return this.accountService.findAll();
	}
	
	/**
	 * This method finds the Accounts via a desired userID
	 * @param id the int representing the userID of the account
	 * @return the list of Account objects found; may be empty
	 */
	@GetMapping(path = "/findByUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> findByUser(@RequestParam int id){
		return this.accountService.findByUserId(id);
	}
	
	/**
	 * This method performs addition on an Account's balance to 
	 * perform a deposit
	 * @param amount the amount that is deposited to the account's balance
	 * @param accountID the int indicating the ID of the account being deposited
	 */
	@PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deposit(@RequestParam int amount, @RequestParam int accountID) {
		this.accountService.deposit(amount, accountID);
	}
	
	/**
	 * This method performs subtraction on an Account's balance to 
	 * perform a withdrawal
	 * @param amount the amount that is withdrawn from the account's balance
	 * @param accountID the int indicating the ID of the account being withdrawn
	 */
	@PostMapping(path = "/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void withdraw(@RequestParam int amount, @RequestParam int accountID) {
		this.accountService.withdraw(amount, accountID);
	}
	
	/**
	 * This method performs subtraction and addition to two different Accounts
	 * to perform a transfer
	 * @param amount the amount that is being transferred from one account to the other
	 * @param fromAccount the Account that is transferring the money; will be subtracted
	 * @param toAccount the Account that the amount is transferred to; will be added
	 */
	@PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void transfer(@RequestParam int amount, @RequestBody Account fromAccount, @RequestBody Account toAccount) {
		this.accountService.withdrawAccount(amount, fromAccount);
		this.accountService.depositAccount(amount, toAccount);
	}
}

	

	

