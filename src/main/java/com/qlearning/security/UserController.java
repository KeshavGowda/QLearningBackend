package com.qlearning.security;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlearning.models.User;
import com.qlearning.repositories.UsersRepository;

@RestController()
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UsersRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(UsersRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping("/sign-up")
	public HttpStatus signUp(@RequestBody User user) {
		try {
			User existingUser = userRepository.findByUsername(user.getUsername());
			if(existingUser == null) {
				String decodedPassword = new String(Base64.getDecoder().decode(user.getPassword()));
				user.setPassword(bCryptPasswordEncoder.encode(decodedPassword));
				userRepository.save(user);
			} else {
				logger.error("Cannot create duplicate user " + user);
				return HttpStatus.CONFLICT;
			}
		} catch (Exception e) {
			logger.error("Exception during User registration", e);
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		logger.info("User " + user + "created successfully");
		return HttpStatus.OK;
	}

}
