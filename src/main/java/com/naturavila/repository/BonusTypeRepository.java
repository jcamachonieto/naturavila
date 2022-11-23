package com.naturavila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naturavila.entity.BonusTypeEntity;

@Repository
public interface BonusTypeRepository extends JpaRepository<BonusTypeEntity, Long>{
	BonusTypeEntity findByName(String name);
}
