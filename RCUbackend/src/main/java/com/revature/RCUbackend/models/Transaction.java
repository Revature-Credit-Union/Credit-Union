package com.revature.RCUbackend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Transaction {
	@Id
	@Column(name = "transactionID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int transactionID;
	@Column(name = "userID")
	int userID;
	@Column(name = "accountID")
	int accountID;
	@Column(name = "transactionType")
	int transactionType; //0 = deposit, 1 = withdrawal, 2 = transfer
	@Column(name = "amount")
	int amount;
	@Column(name = "transactionTimestamp")
	Date transactionTimestamp;
}
