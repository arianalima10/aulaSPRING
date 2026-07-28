package br.com.arianalima.events.repo;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import br.com.arianalima.events.model.Session;
import br.com.arianalima.events.model.Subscription;
import br.com.arianalima.events.model.SubscriptionID;
import br.com.arianalima.events.model.User;

public interface SubscriptionRepo extends ListCrudRepository<Subscription, SubscriptionID>{
	public List<Subscription> findByIdUser(User user);
	public List<Subscription> findByIdSession(Session session);
}