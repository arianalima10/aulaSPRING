package br.com.arianalima.events.service;

import java.util.List;

import br.com.arianalima.events.model.Session;
import br.com.arianalima.events.model.Subscription;
import br.com.arianalima.events.model.User;

public interface ISubscriptionService {
	public Subscription addSubscription(Subscription subscription);
	public List<Subscription> getAllByUser(User user);
	public List<Subscription> getAllBySession(Session session);
}