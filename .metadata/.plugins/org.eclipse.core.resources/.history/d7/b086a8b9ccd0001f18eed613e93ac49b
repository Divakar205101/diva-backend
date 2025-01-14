package com.div.serviceImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.div.domain.BaseVO;
import com.div.domain.SetAdditionalFeilds;
import com.div.repo.CommonRepository;
import com.div.service.CommonService;

@Service
@Transactional
public abstract class CommonRepositoryImpl<T extends BaseVO, ID extends Serializable> implements CommonService<T, ID> {

	private CommonRepository<T, ID> commonRepository;

	@Autowired
	public CommonRepositoryImpl(CommonRepository<T, ID> commonRepository) {
		this.commonRepository = commonRepository;
	}

	@Override
	public void save(T entity) {
		SetAdditionalFeilds.setFeilds(entity);
		 commonRepository.save(entity);
	}

	@Override
	public List<T> findAll() {
		return commonRepository.findAll();
	}

	@Override
	public Optional<T> findById(ID entityId) {
		return commonRepository.findById(entityId);
	}

	@Override
	public T update(T entity) {
		return (T) commonRepository.save(entity);
	}

	@Override
	public T updateById(T entity, ID entityId) {
		Optional<T> optional = commonRepository.findById(entityId);
		if (optional.isPresent()) {
			return (T) commonRepository.save(entity);
		} else {
			return null;
		}
	}

	@Override
	public void delete(T entity) {
		commonRepository.delete(entity);
	}

	@Override
	public void deleteById(ID entityId) {
		commonRepository.deleteById(entityId);
	}

}
