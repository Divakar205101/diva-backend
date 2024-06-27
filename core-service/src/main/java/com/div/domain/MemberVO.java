package com.div.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity
@Table(name = "DIV_MEMBER")
public class MemberVO extends BaseVO {
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMCOMM_ID")
	private MemberCommVO memberCommVO =new MemberCommVO();
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "MIDDLENAME")
	private String middleName;

	@Column(name = "ADHARNO")
	private String adharNumber;
	
	@Column(name = "DATEOFBIRTH")
	private Date dateOfBirth;

	@Column(name = "PINCODE")
	private Integer pinCode;
	
	@Column(name = "AGE")
	private Integer age;

	@JsonManagedReference
	@OneToMany(mappedBy ="memberVO",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MemberBanksVO> memberBanksVOs = new ArrayList<MemberBanksVO>();
	
	 
	 

}