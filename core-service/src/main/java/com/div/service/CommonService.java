package com.div.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.div.domain.BaseVO;

public interface CommonService<T extends BaseVO, ID extends Serializable> {

	 	public abstract void save(T entity);
	    public abstract List<T> findAll(); // you might want a generic Collection if u prefer
	    public abstract Optional<T> findById(ID entityId);
	    public abstract T update(T entity);
	    public abstract T updateById(T entity, ID entityId);   
	    public abstract void delete(T entity);
	    public abstract void deleteById(ID entityId);
}
