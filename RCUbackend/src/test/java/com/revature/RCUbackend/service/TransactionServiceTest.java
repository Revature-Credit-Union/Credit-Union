package com.revature.RCUbackend.service;


import com.revature.RCUbackend.controller.UserController;
import com.revature.RCUbackend.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionServiceTest {

    TransactionService transactionService;
    TransactionRepository testRepo;

    @BeforeEach
    void setUp(){
        testRepo = new TransactionRepository();
        this.transactionService = new TransactionService(testRepo);
    }

    @Test
    void findAllTest(){}

    @Test
    void findByTransactionIDTest(){}

    @Test
    void findByUserIDTest(){}

    @Test
    void findByAccountID(){}

    @Test
    void findByTransactionTypeAndUserIDTest(){}

    @Test
    void findByUserTransactionTypeAndAccountIDTest(){}

    @Test
    void saveTransactionTest(){}
}
