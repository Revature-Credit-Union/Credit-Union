package com.revature.RCUbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.RCUbackend.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	public List<Transaction> findAll();
	
	public Transaction saveTransaction(Transaction transaction);
	
	public Transaction findbyTransactionID(int id);
	
	public List<Transaction> findbyUserID(int id);
	
	public List<Transaction> findbyAccountID(int id);
	
	public List<Transaction> findbyTranscationType(int type);
	
	public List<Transaction> findbyTranscationTypeAndUserID(int type, int id);
	
	public List<Transaction> findbyTranscationTypeAndAccountID(int type, int id);
}
