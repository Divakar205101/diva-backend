package com.diva.mo;

import com.diva.vto.UserVTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMTO {
	private UserVTO userVO=new UserVTO();
}