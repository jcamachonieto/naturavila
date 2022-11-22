package com.naturavila.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "bonus")
@Data
public class BonusEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean gift;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bonusType_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BonusTypeEntity bonusType;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private UserEntity user;
	
	private int numTickets;
	
	@Column(name = "operation")
	private String operation;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime timestamp;
	
	@PrePersist
	public void onPrePersist() {
		audit("INSERT");
	}

	@PreUpdate
	public void onPreUpdate() {
		audit("UPDATE");
	}

	@PreRemove
	public void onPreRemove() {
		audit("DELETE");
	}

	private void audit(String operation) {
		setOperation(operation);
		setTimestamp(LocalDateTime.now());
	}

}
