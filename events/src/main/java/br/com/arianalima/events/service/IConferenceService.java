package br.com.arianalima.events.service;

import java.util.List;

import br.com.arianalima.events.model.Conference;

public interface IConferenceService {
	public Conference addConference(Conference conference);
	public Conference getConferenceById(Integer id);
	public List<Conference> getAllConferences();
}