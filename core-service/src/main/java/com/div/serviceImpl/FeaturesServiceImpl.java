package com.div.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.div.domain.FeaturesVO;
import com.div.repo.FeaturesRepository;
import com.div.service.FeaturesService;
@Service
@Transactional
public class FeaturesServiceImpl implements FeaturesService{
	
	@Autowired private FeaturesRepository featuresDAO;

	@Override
	public void saveFeatures(FeaturesVO featuresDO) {
		featuresDAO.save(featuresDO);
	}

}
