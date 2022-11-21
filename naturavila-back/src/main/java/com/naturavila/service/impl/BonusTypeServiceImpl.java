package com.naturavila.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturavila.entity.BonusTypeEntity;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.repository.BonusTypeRepository;
import com.naturavila.service.BonusTypeService;

@Service
public class BonusTypeServiceImpl implements BonusTypeService {

	@Autowired
	private BonusTypeRepository bonusTypeRepository;

	@Override
	public BonusTypeEntity save(BonusTypeEntity bonusType) throws NaturavilaException {
		if (bonusTypeRepository.findByName(bonusType.getName()) == null) {
			return bonusTypeRepository.save(bonusType);
		} else {
			throw new NaturavilaException("bonusType exists");
		}
	}

	@Override
	public List<BonusTypeEntity> getAll() {
		return bonusTypeRepository.findAll();
	}

}
