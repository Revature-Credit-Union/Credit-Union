package com.revature.RCUbackend.models;

import javax.persistence.*;

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_id_seq")
    @Column(name="id", columnDefinition="int")
    @SequenceGenerator(name="address_id_seq", sequenceName="address_id_seq",  allocationSize=1)
    private int id;
    private int user_id;
    private String type;
    private Double balance;

    public Account(int id, int user_id, String type, Double balance) {
        this.id = id;
        this.user_id = user_id;
        this.type = type;
        this.balance = balance;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
