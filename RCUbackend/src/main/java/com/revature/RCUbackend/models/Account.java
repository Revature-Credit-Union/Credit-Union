package com.revature.RCUbackend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "accountID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int accountId;
	@Column(name = "userID")
	int userId;
	@Column(name = "accountType")
	int accountType; //0 = checking, 1 = savings
	@Column(name = "balance")
	int balance;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="accountID")
	private List<Transaction> transactions;
}

