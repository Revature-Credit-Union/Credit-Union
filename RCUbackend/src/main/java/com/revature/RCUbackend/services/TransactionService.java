package com.revature.RCUbackend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.RCUbackend.models.Transaction;
import com.revature.RCUbackend.repositories.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	private TransactionRepository transactionRepository;
	
	/**
	 * The constructor for the TransactionService class
	 * @param transactionRepository the TransactionRepository instance used to
	 * access the repository layer of the application
	 */
	@Autowired
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	/**
     * This method retrieves all Transactions from the database
     * This method can be removed in favor of the built-in findAll method
     * that comes with extending JpaRepository
     * @return the list of Transaction objects; may be empty
	 */
	public List<Transaction> findAll() {
		return this.transactionRepository.findAll();
	}
	
	/**
	 * This method finds the Transaction by the desired transactionID
	 * @param id the int representing the transactionID of the transaction
	 * @return the Transaction object of the desired transactionID
	 */
	public Transaction findByTransactionID(int id) {
		return this.transactionRepository.findByTransactionID(id);
	}
	
	/**
	 * This method finds the Transactions by the desired accountID
	 * @param id the int representing the accountID of the transaction
	 * @return the list of Transaction objects of the desired accountID; may be empty
	 */
	public List<Transaction> findByAccountID(int id) {
		return this.transactionRepository.findByAccountID(id);
	}
	
	/**
	 * This method finds the Transactions by the desired transaction type and accountID
	 * @param type the int representing the transaction type of the transaction
	 * @param id the int representing the accountID of the transaction
	 * @return the list of Transaction objects of the desired transaction type and accountID; 
	 * may be empty
	 */
	public List<Transaction> findByTransactionTypeAndAccountID(int type, int id) {
		return this.transactionRepository.findByTransactionTypeAndAccountID(type, id);
	}
	
	/**
     * This method persists the Transaction to the database
	 * @param transaction the Transaction object to be saved
	 * @return the Transaction object that was saved
	 */
	public Transaction saveTransaction(Transaction transaction) {
		return this.transactionRepository.saveTransaction(transaction);
	}
}