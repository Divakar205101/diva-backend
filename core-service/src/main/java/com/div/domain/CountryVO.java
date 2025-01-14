package com.div.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity
@Table(name = "DIV_COUNTRY")
public class CountryVO extends BaseVO {

	@Column(name = "COUNTRYID")
	private String countryId;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "COUNTRYCODE")
	private String countryCode;

}
