package com.div.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.div.mo.UserMO;
import com.div.mto.UserMTO;
import com.div.service.UserService;
import com.div.vto.UserVTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	private static final String SAVEUSER="/saveUser";
	private static final String ACTION = "action";
	
	@Autowired private ObjectMapper mapper;
	@Autowired private  UserService userService;
	
	 
	@PostMapping(value=SAVEUSER)
	 public ResponseEntity<UserMTO> createUser(@RequestParam(ACTION) String fooId,@RequestBody UserMTO userMTO){
		 UserVTO userVTO = new UserVTO();
		 try {
			UserMO userMO_DB = null;
			UserMO userMO = mapper.convertValue(userMTO, UserMO.class); 
			userService.createUser(userMO.getUserVO());
		} catch (Exception e) {
			
		}
	     return new ResponseEntity<>(userMTO, HttpStatus.CREATED);
	  }
}
