package com.div.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIVMEM_MEMCOMM")
public class MemberCommVO extends BaseVO {

	@Column(name = "EMAIL")
	private String primail;
	@Column(name = "MOBILENO")
	private String mobileNumber;
	@Column(name = "LANNO")
	private String lanNumber;

}
