package com.div.service;

import java.util.List;

import com.div.domain.UserVO;

public interface UserService {

	UserVO createUser(UserVO user);
	UserVO getUserById(Integer userId);
    List<UserVO> getAllUsers();
    UserVO updateUser(UserVO user);
    void deleteUser(Integer userId);
}
