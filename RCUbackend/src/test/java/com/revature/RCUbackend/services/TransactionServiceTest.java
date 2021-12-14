package com.revature.RCUbackend.services;



import com.revature.RCUbackend.models.Transaction;
import com.revature.RCUbackend.repositories.TransactionRepository;
import com.revature.RCUbackend.repositories.TransactionRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TransactionServiceTest {

    TransactionService transactionService;
    TransactionRepository testRepo;

    @BeforeEach
    void setUp(){
        testRepo = new TransactionRepository() {
            @Override
            public List<Transaction> findAll() {
                return null;
            }

            @Override
            public List<Transaction> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Transaction> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public List<Transaction> findAllById(Iterable<Integer> iterable) {
                return null;
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
            public <S extends Transaction> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Transaction> List<S> saveAll(Iterable<S> iterable) {
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
            public <S extends Transaction> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
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
        };
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
