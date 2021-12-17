package com.revature.RCUbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.RCUbackend.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	/**
     * This method retrieves all Transactions from the database
     * This method can be removed in favor of the built-in findAll method
     * that comes with extending JpaRepository
     * @return the list of Transaction objects
	 */
	public List<Transaction> findAll();
	
	/**
     * This method persists the Transaction to the database
     * This method can be removed in favor of the built-in save method
     * that comes with extending JpaRepository
	 * @param transaction the Transaction object to be saved
	 * @return the Transaction object that was saved
	 */
	public default Transaction saveTransaction(Transaction transaction) {
		return save(transaction);
	}
	
	/**
	 * This method finds the Transaction by the desired transactionID
	 * @param id the int representing the transactionID of the transaction
	 * @return the Transaction object of the desired transactionID
	 */
	public Transaction findByTransactionID(int id);

	/**
	 * This method finds the Transactions by the desired accountID
	 * @param id the int representing the accountID of the transaction
	 * @return the list of Transaction objects of the desired accountID
	 */
	public List<Transaction> findByAccountID(int id);
	
	/**
	 * This method finds the Transactions by the desired transaction type and accountID
	 * @param type the int representing the transaction type of the transaction
	 * @param id the int representing the accountID of the transaction
	 * @return the list of Transaction objects of the desired transaction type and accountID
	 */
	public List<Transaction> findByTransactionTypeAndAccountID(int type, int id);
}
