package com.revature.RCUbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.RCUbackend.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	public List<Transaction> findAll();
	
	public default Transaction saveTransaction(Transaction transaction) {
		return save(transaction);
	}
	
	public Transaction findByTransactionID(int id);
	
	public List<Transaction> findByUserID(int id);
	
	public List<Transaction> findByAccountID(int id);
	
	public List<Transaction> findByTransactionTypeAndUserID(int type, int id);
	
	public List<Transaction> findByTransactionTypeAndAccountID(int type, int id);
}
