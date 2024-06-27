package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.div.domain.FeaturesVO;

public interface FeaturesRepository extends JpaRepository<FeaturesVO, Integer> {

}
