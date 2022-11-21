package com.naturavila.service;

import java.util.List;

import com.naturavila.entity.BonusTypeEntity;
import com.naturavila.exception.NaturavilaException;

public interface BonusTypeService {
	
	BonusTypeEntity save(BonusTypeEntity bonusType) throws NaturavilaException;
	
	List<BonusTypeEntity> getAll();

}
