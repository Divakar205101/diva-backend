package com.div.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.UserVO;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer> {
	Optional<UserVO> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
