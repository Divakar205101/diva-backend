package com.div.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity
@Table(name = "DIV_INTERM")
public class IntermVO extends BaseVO {

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "MIDDLENAME")
	private String middleName;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "ADHARNO")
	private String adharNo;

	@Column(name = "PINCODE")
	private Integer pinCode;

	@OneToOne
	@JoinColumn(name = "COUNTRY")
	private CountryVO countryDO;

	
	 
	 

}
