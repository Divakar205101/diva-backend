package com.div.service;

import java.util.List;

import com.div.domain.MemberVO;

public interface MemberService {

	MemberVO createUser(MemberVO memberVO);
	MemberVO getUserById(Integer userId);
    List<MemberVO> getAllUsers();
    MemberVO updateUser(MemberVO memberVO);
    void deleteUser(Integer userId);
}
