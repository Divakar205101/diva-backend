package com.div.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "DIV_BANK")
public class BankVO extends BaseVO{

	@Column(name = "BANKID")
	private String bankId;
	
	@Column(name = "BANKNAME")
	private String bankname;
	
}
