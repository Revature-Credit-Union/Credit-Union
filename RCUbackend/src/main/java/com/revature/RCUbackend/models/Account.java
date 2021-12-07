package com.revature.RCUbackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "accountID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int accountId;
	@Column(name = "userID")
	String userId;
	@Column(name = "accountType")
	int accountType; //0 = checking, 1 = savings
	@Column(name = "balance")
	int balance;
}
