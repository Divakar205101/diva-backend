package com.diva.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVTO {

	private Integer Id;
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
}
