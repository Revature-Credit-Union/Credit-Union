package com.revature.RCUbackend.controllers;

import com.revature.RCUbackend.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TransactionControllerTest {

    TransactionController transactionController;

    @Mock
    TransactionService transactionService;

    @BeforeEach
    void setUp(){
        this.transactionController = new TransactionController(transactionService);
    }

    @Test
    void allTransactionsTest(){}

    @Test
    void saveTransactionTest(){}

    @Test
    void getallTest(){}

    @Test
    void findByUserTest(){}

    @Test
    void findByAccountTest(){}

    @Test
    void findDepositsTest(){}

    @Test
    void findWithdrawalsTest(){}

}
