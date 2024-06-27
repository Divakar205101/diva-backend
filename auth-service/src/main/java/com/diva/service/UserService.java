package com.diva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diva.domain.UserVO;
import com.diva.repo.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository userRepository;
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private JwtService jwtService;
	
	public String saveUser(UserVO userVO) {
		userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
		userRepository.save(userVO);
		return "user saved";
	}
	
	public String genrateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}
}
