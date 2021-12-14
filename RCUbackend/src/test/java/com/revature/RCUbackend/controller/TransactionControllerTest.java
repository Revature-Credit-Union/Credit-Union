package com.revature.RCUbackend.controller;


import com.revature.RCUbackend.controllers.TransactionController;
import com.revature.RCUbackend.models.Transaction;
import com.revature.RCUbackend.repositories.TransactionRepository;
import com.revature.RCUbackend.services.TransactionService;



//import com.revature.RCUbackend.services.*;
import org.junit.Test;
import org.mockito.Mock;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.Assert.assertNotNull;

public class TransactionControllerTest {

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
        testRepo = new TransactionRepository() {
            @Override
            public List<Transaction> findAll() {
                return null;
            }

            @Override
            public Transaction findByTransactionID(int id) {
                return null;
            }

            @Override
            public List<Transaction> findByUserID(int id) {
                return null;
            }

            @Override
            public List<Transaction> findByAccountID(int id) {
                return null;
            }

            @Override
            public List<Transaction> findByTransactionTypeAndUserID(int type, int id) {
                return null;
            }

            @Override
            public List<Transaction> findByTransactionTypeAndAccountID(int type, int id) {
                return null;
            }

            @Override
            public List<Transaction> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Transaction> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

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
                return null;
            }

            @Override
            public Transaction getById(Integer integer) {
                return null;
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
                return 0;
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
        t1.setAccountID(0);
        t1.setAmount(0);
        t1.setTransactionID(0);

        t2 = new Transaction();
        t1.setAccountID(9999999);
        t1.setAmount(0);
        t1.setTransactionID(9999999);
    }

    @Test
    public void saveTransactionTest(){
        transactionController.saveTransaction(t1);
    }

    @Test
    public void getallTest(){
        assertNotNull(transactionController.getall());
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

}
