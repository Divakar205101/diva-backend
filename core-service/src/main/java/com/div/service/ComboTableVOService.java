package com.div.service;

import java.util.List;

import com.div.domain.ComboTableVO;

public interface ComboTableVOService {
	
	ComboTableVO save(ComboTableVO comboTableVO);
	List<ComboTableVO> findAll();
	List<ComboTableVO> getByTableFeild(String tableFeild);

}