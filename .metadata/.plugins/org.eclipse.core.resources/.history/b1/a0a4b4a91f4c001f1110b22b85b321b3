package com.div.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIVMEM_MEMBANK")
public class MemberBanksVO extends BaseVO{
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "MEMBER_ID")
	private MemberVO memberVO;
	
	@Column(name = "BANK")
	private String bank;
	
	@Column(name = "ACCOUNTNO")
	private String accountno;
	
	@Column(name = "BRANCH")
	private String branch;
	
	@Column(name = "IFSCCODE")
	private String ifscCode;
	
	@Column(name = "ACCOUNTTYPE")
	private String accountType;
	

}
