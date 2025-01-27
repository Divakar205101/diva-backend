package com.div.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.div.domain.ComboTableVO;

@Repository
public interface ComboTableVORepo extends JpaRepository<ComboTableVO, Integer>{
//	
//	public static final String HASH_KEY ="COMBOTABLE";
//	
//	public static final RedisTemplate redisTemplate = new RedisTemplate();
//	
//	public static void save(ComboTableVO comboTableVO) {
//		redisTemplate.opsForHash().put(HASH_KEY, comboTableVO.getTableFeild(), comboTableVO);
//	}
//	
//	public static List<ComboTableVO> findAll(){
//		return redisTemplate.opsForHash().values(HASH_KEY);
//	}
//	
//	public static ComboTableVO findComboTableVOByTableFeild(String tableFeild) {
//		return (ComboTableVO)redisTemplate.opsForHash().get(HASH_KEY, tableFeild);
//	}
//	
//	public static void deleteTableFeild(String tableFeild) {
//		redisTemplate.opsForHash().delete(HASH_KEY, tableFeild);
//	}

}
