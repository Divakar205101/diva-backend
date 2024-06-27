package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.UserVO;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer>{

}
