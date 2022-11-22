package com.naturavila.service;

import java.util.List;

import com.naturavila.entity.BonusTypeEntity;
import com.naturavila.exception.NaturavilaException;

public interface BonusTypeService {
	
	BonusTypeEntity create(BonusTypeEntity bonusType) throws NaturavilaException;
	
	List<BonusTypeEntity> getAll();
	
	BonusTypeEntity findById(Long id) throws NaturavilaException;
	
	BonusTypeEntity update(Long id, Boolean enabled) throws NaturavilaException;

}
