package com.div.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "DIV_BANK")
public class BankVO extends BaseVO {

	@Column(name = "BANKID")
	private String bankId;

	@Column(name = "BANKNAME")
	private String bankname;

}
