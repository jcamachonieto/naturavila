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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Long id;

	@NotBlank(message = "firstName is mandatory")
	private String firstName;

	private String lastName;

	@NotBlank(message = "identifier is mandatory")
	@Column(unique = true)
	private String identifier;

	private String email;

	@NotBlank(message = "password is mandatory")
	private String password;

	private Boolean enabled;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RoleEntity role;

	@Column(name = "operation")
	private String operation;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime timestamp;

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
		setTimestamp(LocalDateTime.now());
	}

}
