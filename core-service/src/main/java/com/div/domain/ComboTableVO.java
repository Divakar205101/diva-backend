package com.div.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DIV_COMBOTABLE")
public class ComboTableVO extends BaseVO {
	@Column(name = "TABLEFEILD")
	private String tableFeild;
	@Column(name = "CONBOFEILD")
	private String comboFeild;
	@Column(name = "COMBOTEXT")
	private String cobotext;

}
