package br.com.arianalima.authapi.service;

import br.com.arianalima.authapi.model.User;
import br.com.arianalima.authapi.security.MyToken;

public interface IUserService {
	public User addUser(User user);
	public User getByUsername(String username);
	public MyToken userLogin(User user);
}