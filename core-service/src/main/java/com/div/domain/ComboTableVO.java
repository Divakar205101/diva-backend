package com.div.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

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