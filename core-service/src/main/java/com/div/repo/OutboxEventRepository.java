package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.OutboxEventVO;

@Repository
public interface OutboxEventRepository  extends JpaRepository<OutboxEventVO, Long>{

}
