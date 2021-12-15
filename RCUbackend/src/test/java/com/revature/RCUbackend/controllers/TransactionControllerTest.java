package com.revature.RCUbackend.controllers;


import com.revature.RCUbackend.services.TransactionService;



//import com.revature.RCUbackend.services.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertNotNull;

public class TransactionControllerTest {
/*
    TransactionController transactionController;

    @Mock
    TransactionRepository testRepo;

    @Mock
    TransactionService transactionService;

    @Mock
    Transaction t1;

    @Mock
    Transaction t2;

    @BeforeEach
    void setUp(){
        this.testRepo = new TransactionRepository() {

            List<Transaction> testList = new ArrayList<>();

            @Override
            public List<Transaction> findAll() {
                return this.testList;
            }

            @Override
            public Transaction findByTransactionID(int id) {
                for(int i = 0; i < testList.size(); i++)
                    if(testList.get(i).getTransactionID() == id)
                        return testList.get(i);

                return null;
            }

            @Override
            public List<Transaction> findByUserID(int id) {
                ArrayList<Transaction> userT = new ArrayList<>();

                for(int i = 0; i < testList.size(); i++)
                    if(testList.get(i).getUserID() == id)
                        userT.add(testList.get(i));

                return userT;
            }

            @Override
            public List<Transaction> findByAccountID(int id) {
                ArrayList<Transaction> accountT = new ArrayList<>();

                for(int i = 0; i < testList.size(); i++)
                    if(testList.get(i).getUserID() == id)
                        accountT.add(testList.get(i));

                return accountT;
            }

            @Override
            public List<Transaction> findByTransactionTypeAndUserID(int type, int id) {
                List<Transaction> userT = findByUserID(id);
                List<Transaction> both = new ArrayList<>();
                for(int i = 0; i < userT.size(); i++)
                    if(userT.get(i).getTransactionType() == type)
                        both.add(userT.get(i));

                return both;

            }

            @Override
            public List<Transaction> findByTransactionTypeAndAccountID(int type, int id) {
                List<Transaction> accountT = findByAccountID(id);
                List<Transaction> both = new ArrayList<>();
                for(int i = 0; i < accountT.size(); i++)
                    if(accountT.get(i).getTransactionType() == type)
                        both.add(accountT.get(i));

                return both;
            }

            @Override
            public List<Transaction> findAll(Sort sort) {
                return testList;
            }

            @Override //Not sure how this one is supposed to work
            public List<Transaction> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {
                this.testList = new ArrayList<>();
            }

            @Override
            public <S extends Transaction> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> saveAllAndFlush(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Transaction> iterable) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Transaction getOne(Integer integer) {
                return findByTransactionID(integer);
            }

            @Override
            public Transaction getById(Integer integer) {
                return findByTransactionID(integer);
            }

            @Override
            public <S extends Transaction> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Transaction> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Transaction> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Transaction> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return testList.size();
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Transaction entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends Transaction> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Transaction> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Transaction> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Transaction> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Transaction> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Transaction, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        this.transactionService = new TransactionService(testRepo);
        this.transactionController = new TransactionController(transactionService);
        t1 = new Transaction();
        t1.setAccountID(1);
        t1.setAmount(20);
        t1.setTransactionID(1);

        t2 = new Transaction();
        t2.setAccountID(2);
        t2.setAmount(20);
        t2.setTransactionID(2);

        testRepo.saveTransaction(t1);
        testRepo.saveTransaction(t2);
    }

    @Test
    public void saveTransactionTest(){
        Transaction t3 = new Transaction();
        t3.setTransactionID(3);
        transactionController.saveTransaction(t3);
        assertNotNull(testRepo.findByTransactionID(3));
    }

    @Test
    public void getallTest(){
        //assertNotNull(transactionController.getall());
    }

    @Test
    public void findByUserTest(){
        //transactionController.findbyUser();
    }

    @Test
    public void findByAccountTest(){
        //transactionController.findbyAccount()
    }

    @Test
    public void findDepositsTest(){
        //transactionController.findDeposits()
    }

    @Test
    public void findWithdrawalsTest(){}
*/
}
