package com.diva.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

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

import com.diva.mo.UserMTO;
import com.diva.mto.UserMO;
import com.diva.repo.UserRepository;
import com.diva.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Auth Service",description = "Auth Request Controller")
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final String SAVE_USER = "/signon";
	private static final String GEN_TOKEN = "/gentoken";
	private static final String VALID_TOKEN = "/validtoken";
	private static final String CHECKUSERID_PRESENT = "/checkUserIdPresent";

 	@Autowired private UserService userService;
 	@Autowired private AuthenticationManager authenticationManager;
 	@Autowired private UserRepository userRepository;
 	@Autowired ObjectMapper mapper;
 	
 	@ApiOperation(value ="User Register API") //Two show method name In Swagger UI
 	@PostMapping(SAVE_USER)
 	public String register(@RequestBody @Valid UserMTO userMTO) {
 		
 		UserMO userMO;
 		userMO = mapper.convertValue(userMTO, UserMO.class);
 	 return userService.saveUser(userMO.getUserVO());
         
 	}
 	
 	@GetMapping(GEN_TOKEN)
 	public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password) {
 		try {
 			Map<Object, Object> hashMap = new LinkedHashMap();
 			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
 			if (authenticate.isAuthenticated()) {
 	 			 String genrateToken = userService.genrateToken(email);
 	 			hashMap.put("user", authenticate.getPrincipal());
 	 			hashMap.put("role", "ADMIN");
 	 			hashMap.put("accessToken", genrateToken);
 	 			return ResponseEntity.ok(hashMap);
 			}else {
 				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
 			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
		}
 	}
 	
 	@GetMapping(CHECKUSERID_PRESENT)
 	public ResponseEntity<Boolean> checkUserIdPresent(@RequestParam("email") String email) {
 		if (userRepository.existsByEmail(email)) {
 			return ResponseEntity.ok(Boolean.TRUE);
		} else {
			return ResponseEntity.ok(Boolean.FALSE);
		}
	}
 	
 	@GetMapping(VALID_TOKEN)
 	public String validateToken(@RequestParam("token") String token) {
 		userService.validateToken(token);
 		return "Valid Token";
 	}
}
