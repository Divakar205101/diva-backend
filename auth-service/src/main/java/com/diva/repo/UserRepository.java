package com.diva.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diva.domain.UserVO;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer> {
	Optional<UserVO> findByEmail(String username);
	boolean existsByEmail(String email);

}
