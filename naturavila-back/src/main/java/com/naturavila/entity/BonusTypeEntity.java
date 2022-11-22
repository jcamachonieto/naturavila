package com.naturavila.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Entity
@Table(name = "bonusTypes")
@Data
public class BonusTypeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "name is mandatory")
	private String name;

	@NotNull(message = "quantity is mandatory")
	@Range(min = 1)
	private int quantity;
	
	private Boolean enabled;
	
	@Column(name = "operation")
	private String operation;

	@Column(name = "timestamp")
	private long timestamp;
	
	@PrePersist
	public void onPrePersist() {
		setEnabled(Boolean.TRUE);
		audit("INSERT");
	}

	@PreUpdate
	public void onPreUpdate() {
		audit("UPDATE");
	}

	@PreRemove
	public void onPreRemove() {
		setEnabled(Boolean.FALSE);
		audit("DELETE");
	}

	private void audit(String operation) {
		setOperation(operation);
		setTimestamp((new Date()).getTime());
	}

}
