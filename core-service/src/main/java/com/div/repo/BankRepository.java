package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.BankVO;
@Repository
public interface BankRepository extends JpaRepository<BankVO, Integer>{

}
