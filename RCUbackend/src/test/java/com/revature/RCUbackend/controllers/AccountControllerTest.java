package com.revature.RCUbackend.controllers;


import com.revature.RCUbackend.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.repositories.AccountRepository;
//import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import com.revature.RCUbackend.services.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountControllerTest {
    AccountController accountController;

    @Mock
    AccountRepository testRepo;

    @Mock
    AccountService accountService;

    @Mock
    Account testUser1;

    @Mock
    Account testUser2;

    @BeforeEach
    void setUp(){
        testRepo = new AccountRepository() {
            List<Account> testList = new ArrayList<>();

            @Override
            public List<Account> findAll() {
                return testList;
            }

            @Override
            public List<Account> getById(int userId) {
                List<Account> toReturn = new ArrayList<>();

                for(int i = 0; i < testList.size(); i++)
                    if(testList.get(i).getAccountId() == userId)
                        toReturn.add(testList.get(i));

                return toReturn;

            }

            @Override
            public void depositAccount(int amount, int accountID) {
                //for(int i = 0; i<testList.size(); i++)

            }

            @Override
            public void withdrawAccount(int amount, int accountID) {

            }

            @Override
            public List<Account> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Account> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public <S extends Account> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Account> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public <S extends Account> List<S> saveAllAndFlush(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Account> iterable) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Account getOne(Integer integer) {
                return null;
            }

            @Override
            public Account getById(Integer integer) {
                return null;
            }

            @Override
            public <S extends Account> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Account> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Account> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Account> findById(Integer integer) {
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
            public void delete(Account entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends Account> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Account> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Account> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Account> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Account, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        this.accountService = new AccountService(testRepo);
        this.accountController = new AccountController(accountService);
        testUser1 = new Account();
        testUser2 = new Account();

        testUser1.setUserId(1);
        testUser2.setUserId(2);


        testUser1.setBalance(200);
        testUser2.setBalance(200);
    }

    @Test
    void depositTest(){
        //System.out.println("testUser1 old balance:" + testUser1.getBalance());
        int newAmount = testUser1.getBalance() + 200;
        accountController.deposit(200, testUser1);
        //System.out.println("testUser1 new balance:" + testUser1.getBalance());
        assertEquals(newAmount, testUser1.getBalance());

        //Okay... so the issue right now is that the deposit method is going through
        //but the test isn't looking at the new balance; it's looking at the old

        /*        //System.out.println("testUser1 old balance:" + testUser1.getBalance());
        int newAmount = testUser1.getBalance() + 200;
        accountController.deposit(200, testUser1);
        //System.out.println("testUser1 new balance:" + testUser1.getBalance());
        testUser1 = testRepo.getById((Integer) testUser1.getAccountId());
        assertEquals(newAmount, testUser1.getBalance());

        This gave me another NullPointerException*/
    }

    @Test
    void withdrawTest(){
        int newAmount = testUser1.getBalance() - 200;
        accountController.withdraw(200, testUser1);
        assertEquals(newAmount, testUser1.getBalance());
    }

    @Test
    void transferTest(){
        int newAmount1 = testUser1.getBalance() - 200;
        int newAmount2 = testUser2.getBalance() + 200;

        accountController.transfer(200, testUser1, testUser2);

        assertEquals(newAmount1, testUser1.getBalance());
        assertEquals(newAmount2, testUser2.getBalance());
    }

    @Test
    void findAllTest(){
        assertNotNull(accountController.findAll());
    }

}
