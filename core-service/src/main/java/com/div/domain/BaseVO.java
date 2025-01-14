package com.div.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseVO implements Serializable {

	private static final long serialVersionUID = 3779027956207925319L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer Id;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDDATE")
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATEDDDATE")
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name = "CREATEDBY")
	private UserVO createdby;

	@ManyToOne
	@JoinColumn(name = "UPDATEDBY")
	private UserVO updatedby;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BaseVO other = (BaseVO) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
