package br.com.arianalima.events.service;

import java.util.List;

import br.com.arianalima.events.model.Session;

public interface ISessionService {
	public Session addSession(Session session);
	public Session getSessionById(Integer id);
	public List<Session> getAllSessions();
}