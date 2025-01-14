package com.div.domain;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
   
	private String userName;
    private String email;
    private String password;
    private Set<String> role;


	

}
