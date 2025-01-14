package com.div.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIVMEM_MEMBANK")
public class MemberBanksVO extends BaseVO {

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
