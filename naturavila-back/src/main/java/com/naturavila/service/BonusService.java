package com.naturavila.service;

import com.naturavila.entity.BonusEntity;
import com.naturavila.exception.NaturavilaException;

public interface BonusService {
	
	BonusEntity findById(Long id) throws NaturavilaException;

}
