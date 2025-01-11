package com.diva.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.diva.enums.ERole;

import lombok.Data;

@Data
@Entity
@Table(name = "DIVSEC_ROLE")
public class RoleVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",unique = true,nullable = false)
	private Integer Id;
	
	@Column(name = "ROLENAME")
	private String roleName;

}
