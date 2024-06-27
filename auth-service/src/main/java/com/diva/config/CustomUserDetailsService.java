package com.diva.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.diva.domain.UserVO;
import com.diva.repo.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
	
	
	@Autowired private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<UserVO> userVO = repository.findByEmail(username);
		return userVO.map(CustomUserVO :: new).orElseThrow(()-> new UsernameNotFoundException("user"+username+"not found "));
	}

}
