package com.div.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIV_MODULE")
public class ModuleVO extends BaseVO {

	@Column(name = "MODULEID")
	private String moduleId;
	@Column(name = "MODULENAME")
	private String moduleName;
	@Column(name = "DESCRIPTION")
	private String description;

	@JsonManagedReference
	@OneToMany(mappedBy = "masterDO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FeaturesVO> featuresDOs = new ArrayList<>();
}
