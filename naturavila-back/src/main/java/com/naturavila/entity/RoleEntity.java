package com.naturavila.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.naturavila.config.RoleName;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class RoleEntity {

	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
	 
     @Enumerated(EnumType.STRING)
     @Column(unique = true, name = "name")
     private RoleName roleName;
     
     public String getName() {
         return roleName.toString();
     }
	
}
