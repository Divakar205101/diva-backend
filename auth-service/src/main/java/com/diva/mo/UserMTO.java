package com.diva.mo;

import javax.validation.Valid;

import com.diva.vto.UserVTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMTO {
	@Valid
	private UserVTO userVO;
}
