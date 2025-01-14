package com.div.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIV_ROLE")
public class RoleMasterVO extends BaseVO {

	@Column(name = "ROLEID")
	private String roleId;	
	@Column(name ="ROLE")
	private String role;
	@Column(name ="DESCRIPTION")
	private String description;
	
}
