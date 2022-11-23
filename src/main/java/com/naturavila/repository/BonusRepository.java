package com.naturavila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naturavila.entity.BonusEntity;

@Repository
public interface BonusRepository extends JpaRepository<BonusEntity, Long>{
	
}
