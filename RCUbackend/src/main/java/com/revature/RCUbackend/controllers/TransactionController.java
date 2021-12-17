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

import com.revature.RCUbackend.models.Transaction;
import com.revature.RCUbackend.services.TransactionService;

@RestController("transactionController")
@RequestMapping("/transaction") //this can be changed depending on frontend
@CrossOrigin(origins="*")
public class TransactionController {
	private TransactionService transactionService;
	
	/**
	 * The constructor for the TransactionController class
	 * @param transactionService the TransactionService instance used to
	 * access the service layer of the application
	 */
	@Autowired
	public TransactionController (TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	/**
	 * This method saves a new Transaction
	 * @param transaction the Transaction object to be saved
	 * @return the Transaction object that was saved; may be null
	 */
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Transaction saveTransaction(@RequestBody Transaction transaction) {
		return this.transactionService.saveTransaction(transaction);
	}
	
	/**
	 * This method finds all of the Transactions.
	 * @return the list of Transaction objects found; may be empty
	 */
	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getall(){
		return this.transactionService.findAll();
	}
	
	/**
	 * This method finds the Transactions via a desired accountID
	 * @param id the int representing the accountID of the account
	 * @return the list of Transaction objects found; may be empty
	 */
	@GetMapping(path = "/findbyAccount", produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findbyAccount(@RequestParam int id) {
		return this.transactionService.findByAccountID(id);
	}
	
	/**
	 * This method finds the deposits via the Transaction type and accountiD
	 * The transaction type will always be 0 for deposits.
	 * @param id the int representing the accountID of the account
	 * @return the list of Transaction objects found; may be empty
	 */
	@GetMapping(path = "/findDeposits", produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findDeposits(@RequestParam int id) {
		return this.transactionService.findByTransactionTypeAndAccountID(0, id);
	}
	
	/**
	 * This method finds the deposits via the Transaction type and accountiD
	 * The transaction type will always be 1 for withdrawals.
	 * @param id the int representing the accountID of the account
	 * @return the list of Transaction objects found; may be empty
	 */
	@GetMapping(path = "/findWithdrawls", produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findWithdrawls(@RequestParam int id) {
		return this.transactionService.findByTransactionTypeAndAccountID(1, id);
	}
	
	/**
	 * This method finds the deposits via the Transaction type and accountiD
	 * The transaction type will always be 2 for transfers.
	 * @param id the int representing the accountID of the account
	 * @return the list of Transaction objects found; may be empty
	 */
	@GetMapping(path = "/findTransfers", produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findTransfers(@RequestParam int id) {
		return this.transactionService.findByTransactionTypeAndAccountID(2, id);
	}
}
