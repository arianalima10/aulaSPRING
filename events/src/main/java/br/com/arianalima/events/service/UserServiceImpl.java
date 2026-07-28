package br.com.arianalima.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.arianalima.events.exception.NotFoundException;
import br.com.arianalima.events.model.User;
import br.com.arianalima.events.repo.UserRepo;

@Service
public class UserServiceImpl implements IUserService{

	private UserRepo repo;

	public UserServiceImpl(UserRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public User getUserById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new NotFoundException("User " + id + " not found"));
	}

	@Override
	public User getUserByEmail(String email) {
		return repo.findByEmail(email).orElseThrow(()-> new NotFoundException("Email " +email + " not registered"));
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}
}