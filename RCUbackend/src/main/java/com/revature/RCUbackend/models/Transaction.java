package com.revature.RCUbackend.models;

import javax.persistence.*;
import java.sql.Date;

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_id_seq")
    @Column(name="id", columnDefinition="int")
    @SequenceGenerator(name="address_id_seq", sequenceName="address_id_seq",  allocationSize=1)
    private int id;

    private int account_id;

    private Date date;//java.sql.Date

    private String type;

    private double amount;

    public Transaction() {
    }

    public Transaction(int id, int account_id, Date date, String type, double amount) {
        this.id = id;
        this.account_id = account_id;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
