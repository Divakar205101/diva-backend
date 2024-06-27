package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.MemberVO;

@Repository
public interface  MemberRepository extends JpaRepository<MemberVO, Integer>{

}
