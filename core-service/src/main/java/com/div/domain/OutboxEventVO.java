package com.div.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIV_OUTBOXEVENT")
public class OutboxEventVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer Id;

	@Column(name = "AGGREGATETYPE", nullable = false)
	private String aggregateType;

	@Column(name = "AGGREGATEID", nullable = false)
	private Integer aggregateId;

	@Column(name = "EVENTTYPE", nullable = false)
	private String eventType;

	@Column(name = "PAYLOAD", nullable = false)
	private String payload;

	@Column(name = "CREATEDAT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATEDAT", nullable = false)
	private Date updatedAt;
}
