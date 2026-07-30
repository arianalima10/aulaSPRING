package br.com.arianalima.authapi.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.com.arianalima.authapi.model.User;
import br.com.arianalima.authapi.repo.UserRepo;
import br.com.arianalima.authapi.security.MyToken;
import br.com.arianalima.authapi.security.TokenUtil;

@Service
public class UserServiceImpl implements IUserService{

	private UserRepo repo;

	public UserServiceImpl(UserRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public User addUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	@Override
	public User getByUsername(String username) {
		return null;
	}

	@Override
	public MyToken userLogin(User user) {
		User storedUser = repo.findByUsername(user.getUsername())
				.orElseThrow(()->new RuntimeException("User not found!"));

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (encoder.matches(user.getPassword(), storedUser.getPassword())) {
			return TokenUtil.encode(storedUser);
		}
		throw new RuntimeException("Unauthorized user");
	}
}