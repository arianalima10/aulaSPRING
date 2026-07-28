package br.com.arianalima.events.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.arianalima.events.model.Session;

public interface SessionRepo extends ListCrudRepository<Session, Integer>{

}