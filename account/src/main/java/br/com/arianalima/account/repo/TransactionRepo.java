package br.com.arianalima.account.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.arianalima.account.model.Transaction;

public interface TransactionRepo extends ListCrudRepository<Transaction, Integer>{

}