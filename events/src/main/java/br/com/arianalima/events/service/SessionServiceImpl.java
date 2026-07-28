package br.com.arianalima.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.arianalima.events.exception.NotFoundException;
import br.com.arianalima.events.model.Session;
import br.com.arianalima.events.repo.SessionRepo;

@Service
public class SessionServiceImpl implements ISessionService{

	private SessionRepo repo;

	public SessionServiceImpl(SessionRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Session addSession(Session session) {
		return repo.save(session);
	}

	@Override
	public Session getSessionById(Integer id) {
		return repo.findById(id).orElseThrow(()-> new NotFoundException("Session " + id + " not found"));
	}

	@Override
	public List<Session> getAllSessions() {
		return repo.findAll();
	}
}