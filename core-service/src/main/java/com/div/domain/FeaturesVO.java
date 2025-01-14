package com.div.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIV_FEATURE")
public class FeaturesVO extends BaseVO {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "MODULE_ID")
	private ModuleVO masterDO;

	@Column(name = "FETUREID")
	private String fetureId;
	@Column(name = "FEATURENAME")
	private String featurename;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "compref")
	private String compref;

}
