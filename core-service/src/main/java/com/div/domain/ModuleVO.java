package com.div.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIV_MODULE")
public class ModuleVO extends BaseVO{

	@Column(name = "MODULEID")
	private String moduleId;
	@Column(name = "MODULENAME")
	private String moduleName;
	@Column(name = "DESCRIPTION")
	private String description;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="masterDO",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FeaturesVO> featuresDOs = new ArrayList<>();
}
