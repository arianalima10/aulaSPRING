package br.com.arianalima.events.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.arianalima.events.model.Session;
import br.com.arianalima.events.model.Subscription;
import br.com.arianalima.events.model.User;
import br.com.arianalima.events.repo.SubscriptionRepo;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService{

	private SubscriptionRepo repo;
	
	public SubscriptionServiceImpl(SubscriptionRepo repo) {
		this.repo = repo;
	}

	@Override
	public Subscription addSubscription(Subscription subscription) {
		subscription.setCreatedAt(LocalDateTime.now());
		subscription.setUniqueID(UUID.randomUUID().toString());
		return repo.save(subscription);
	}

	@Override
	public List<Subscription> getAllByUser(User user) {
		return repo.findByIdUser(user);
	}

	@Override
	public List<Subscription> getAllBySession(Session session) {
		return repo.findByIdSession(session);
	}
}