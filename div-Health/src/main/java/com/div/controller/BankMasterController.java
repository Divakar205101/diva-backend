package com.div.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.div.domain.BankVO;
import com.div.service.BankService;

@RestController
@RequestMapping(value = "/api")
public class BankMasterController {
	
	private static final String SAVEBANK="/savebank";
	
	private BankService bankService;
	
	
	@Autowired
	public BankMasterController(BankService bankService) {
		this.bankService=bankService;
	}

	@PostMapping(value=SAVEBANK)
	 public ResponseEntity<BankVO> createUser(@RequestBody BankVO bankDO){
		// bankService.save(bankDO);
	     return new ResponseEntity<>(bankDO, HttpStatus.CREATED);
	  }

}
