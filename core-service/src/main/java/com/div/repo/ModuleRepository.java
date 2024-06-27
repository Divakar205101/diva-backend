package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.ModuleVO;
@Repository
public interface ModuleRepository extends JpaRepository<ModuleVO, Integer>{

}
