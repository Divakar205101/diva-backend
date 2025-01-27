package com.div.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.div.domain.ComboTableVO;
import com.div.service.ComboTableVOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/combo")
public class ComboTableController {
	
	private static final String ACTION = "action";
	
	@Autowired
	private ComboTableVOService comboTableVOService;
	
	@PostMapping(value = "/savecombo")
	public ResponseEntity<ComboTableVO> save(@RequestBody ComboTableVO comboTableVO) {
		log.debug("combotable save method started");
		comboTableVOService.save(comboTableVO);
		return ResponseEntity.ok(comboTableVO); 
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<ComboTableVO>> getAll() {
		List<ComboTableVO> findAll = comboTableVOService.findAll();
		return ResponseEntity.ok(findAll); 
	}
	
	@GetMapping(value = "/getcombo")
	public ResponseEntity<List<ComboTableVO>> getByTableFeild(@RequestParam("tableFeild") String tableFeild){
		List<ComboTableVO> byTableFeild = comboTableVOService.getByTableFeild(tableFeild);
		return ResponseEntity.ok(byTableFeild); 
	}

}
