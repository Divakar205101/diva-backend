package com.div.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.div.custonexceptionhadler.UserNotFoundException;
import com.div.domain.MemberVO;
import com.div.repo.MemberRepository;
import com.div.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

//	@CacheEvict(value = "getmembers",allEntries = true)
	@Override
	public MemberVO createUser(MemberVO user) {
		return memberRepository.save(user);
	}

	@Override
	public MemberVO getUserById(Integer userId) {
		Optional<MemberVO> findById = memberRepository.findById(userId);
		if (findById.isPresent()) {
			Hibernate.initialize(findById.get().getMemberBanksVOs());
			MemberVO memberVO = findById.get();
			return memberVO;
		} else {
			throw new UserNotFoundException("404","User not Exist with given id ="+userId);
		}
	}

//	@Cacheable("getmembers")
	@Override
	public List<MemberVO> getAllUsers() {
		return memberRepository.findAll();
	}

	@Override
	public MemberVO updateUser(MemberVO user) {
		return memberRepository.save(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		memberRepository.deleteById(userId);
	}

}
