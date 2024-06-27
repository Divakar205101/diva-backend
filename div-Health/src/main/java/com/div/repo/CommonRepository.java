package com.div.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.div.domain.BaseVO;

@NoRepositoryBean
public interface CommonRepository<T extends BaseVO, ID extends Serializable> extends JpaRepository<T, ID>{

}
