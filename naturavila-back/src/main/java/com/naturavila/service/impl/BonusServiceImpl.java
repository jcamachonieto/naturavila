package com.naturavila.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturavila.entity.BonusEntity;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.repository.BonusRepository;
import com.naturavila.service.BonusService;

@Service
public class BonusServiceImpl implements BonusService {

	@Autowired
	private BonusRepository bonusRepository;

	@Override
	public BonusEntity findById(Long id) throws NaturavilaException {
		BonusEntity bonus = bonusRepository.findById(id)
				.orElseThrow(() -> new NaturavilaException("Bonus Not Found with ID :" + id));
		return bonus;
	}

}
