package com.diva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diva.domain.UserVO;
import com.diva.mo.UserMTO;
import com.diva.mto.UserMO;
import com.diva.service.UserService;
import com.diva.vto.UserVTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final String SAVE_USER = "/signon";
	private static final String GEN_TOKEN = "/gentoken";
	private static final String VALID_TOKEN = "/validtoken";

 	@Autowired private UserService userService;
 	@Autowired private AuthenticationManager authenticationManager;
 	@Autowired ObjectMapper mapper;
 	
 	@PostMapping(SAVE_USER)
 	public String addUser(@RequestBody UserMTO userMTO) {
 		UserMO userMO;
 		userMO = mapper.convertValue(userMTO, UserMO.class);
 	 return userService.saveUser(userMO.getUserVO());
 	}
 	
 	@GetMapping(GEN_TOKEN)
 	public ResponseEntity<String> genrateToken(@RequestParam("email") String email, @RequestParam("password") String password) {
 		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
 		try {
 			if (authenticate.isAuthenticated()) {
 	 			 String genrateToken = userService.genrateToken(email);
 	 			return ResponseEntity.ok(genrateToken);
 			}else {
 				throw new RuntimeException("invalid user");
 			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during authentication");
		}
 	}
 	
 	@GetMapping(VALID_TOKEN)
 	public String validateToken(@RequestParam("token") String token) {
 		userService.validateToken(token);
 		return "Valid Token";
 	}
}
