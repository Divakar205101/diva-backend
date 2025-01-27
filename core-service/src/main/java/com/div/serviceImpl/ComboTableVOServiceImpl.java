package com.div.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.div.domain.ComboTableVO;
import com.div.repo.ComboTableVORepo;
import com.div.service.ComboTableVOService;

@Service
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ComboTableVOServiceImpl implements ComboTableVOService {

	@Autowired
	ComboTableVORepo comboTableVORepo;

	@Autowired
	RedisTemplate redisTemplate;

	public static final String HASH_KEY = "COMBOTABLE";

	@Override
	public ComboTableVO save(ComboTableVO comboTableVO) {
		comboTableVORepo.save(comboTableVO);
		redisTemplate.opsForHash().put(HASH_KEY, comboTableVO.getTableFeild(), comboTableVO);
		return comboTableVO;
	}

	@Override
	public List<ComboTableVO> findAll() {
		List<ComboTableVO> findAll = comboTableVORepo.findAll();
		Map<String, List<ComboTableVO>> collect = findAll.stream()
				.collect(Collectors.groupingBy(ComboTableVO::getTableFeild));
		collect.forEach((key, values) -> {
			redisTemplate.opsForHash().put(HASH_KEY, key, values);
		});
//		findAll.forEach(comboTableVO -> {
//		    redisTemplate.opsForHash().put(HASH_KEY, comboTableVO.getTableFeild(), comboTableVO);
//		});
//		redisTemplate.opsForHash().values(HASH_KEY);
		return findAll;
	}

	@Override
	public List<ComboTableVO> getByTableFeild(String tableFeild) {
		Object data = redisTemplate.opsForHash().get(HASH_KEY, tableFeild);
		if (data instanceof List) {
	        return (List<ComboTableVO>) data;
	    } else {
	        throw new ClassCastException("Expected a List<ComboTableVO> but found: " + data.getClass());
	    }
	}

}
