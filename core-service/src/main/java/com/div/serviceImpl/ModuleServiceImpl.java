package com.div.serviceImpl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.div.domain.ModuleVO;
import com.div.repo.ModuleRepository;
import com.div.service.ModuleService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ModuleServiceImpl  implements ModuleService {
	
	@Autowired
	public ModuleRepository moduleRepository;

	@Override
	public List<ModuleVO> getAll() {
		List<ModuleVO> findAll = moduleRepository.findAll();
		findAll.forEach(x->{
			Hibernate.initialize(x.getFeaturesDOs());
		});
		return findAll;
	}

	@Override
	public void savemodule(ModuleVO moduleDO) {
		moduleRepository.save(moduleDO);
	}
	
	

	

}
