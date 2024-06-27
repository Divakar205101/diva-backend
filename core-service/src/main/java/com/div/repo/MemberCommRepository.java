package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.MemberCommVO;
@Repository
public interface MemberCommRepository extends JpaRepository<MemberCommVO, Integer>{

}
