package com.div.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
	@OneToMany(mappedBy ="memberVO",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<MemberBanksVO> memberBanksVOs = new ArrayList<MemberBanksVO>();
	
	 
	 

}
