package br.com.arianalima.events.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.arianalima.events.model.Conference;

public interface ConferenceRepo extends ListCrudRepository<Conference, Integer>{

}