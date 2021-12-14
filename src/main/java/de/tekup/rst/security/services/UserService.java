package de.tekup.rst.security.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import de.tekup.rst.security.entities.User;
import de.tekup.rst.security.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder cryptPasswordEncoder;
	public void registerUser(User user) {
		user.setPassword(cryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
