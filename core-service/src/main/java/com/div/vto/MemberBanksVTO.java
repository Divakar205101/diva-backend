package com.div.vto;

import com.div.domain.MemberVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberBanksVTO {
   
	private Integer id;
	private MemberVO memberVO;
	private String bank;
	private String accountno;
	private String branch;
	private String ifscCode;
	private String accountType;
}
