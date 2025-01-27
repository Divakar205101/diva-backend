package com.div.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.div.domain.UserVO;
import com.div.repo.UserRepository;
import com.div.service.UserService;

import lombok.AllArgsConstructor;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserVO createUser(UserVO user) {
		return userRepository.save(user);
	}

	@Override
	public UserVO getUserById(Integer userId) {
		Optional<UserVO> findById = userRepository.findById(userId);
		return findById.get();
	}

	@Override
	public List<UserVO> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserVO updateUser(UserVO user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

}
