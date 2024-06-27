package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.MemberBanksVO;
@Repository
public interface MemberBanksRepository extends JpaRepository<MemberBanksVO, Integer> {

}
