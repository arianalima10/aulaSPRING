package br.com.arianalima.account.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.arianalima.account.model.Account;

public interface AccountRepo extends ListCrudRepository<Account, Integer> {

}