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
	public BonusTypeEntity create(BonusTypeEntity bonusType) throws NaturavilaException {
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

	@Override
	public BonusTypeEntity findById(Long id) throws NaturavilaException {
		BonusTypeEntity bonusType = bonusTypeRepository.findById(id)
				.orElseThrow(() -> new NaturavilaException("BonusType Not Found with ID :" + id));
		return bonusType;
	}

	@Override
	public BonusTypeEntity update(Long id, Boolean enabled) throws NaturavilaException {
		BonusTypeEntity bonusType = this.findById(id);
		bonusType.setEnabled(enabled);
		return bonusTypeRepository.save(bonusType);
	}

}
