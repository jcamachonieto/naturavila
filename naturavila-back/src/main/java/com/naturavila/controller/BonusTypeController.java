package com.naturavila.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturavila.entity.BonusTypeEntity;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.service.BonusTypeService;

@RestController
@RequestMapping("/protected/bonusType")
public class BonusTypeController {

	@Autowired
	private BonusTypeService bonusTypeService;

	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	ResponseEntity<BonusTypeEntity> addBonusType(@Valid @RequestBody BonusTypeEntity bonusType)
			throws NaturavilaException {
		BonusTypeEntity bonusTypeDB = bonusTypeService.create(bonusType);
		return ResponseEntity.ok(bonusTypeDB);
	}

	@GetMapping
	ResponseEntity<List<BonusTypeEntity>> getAll() {
		return ResponseEntity.ok(bonusTypeService.getAll());
	}

	@DeleteMapping(value = "/{id}")
	ResponseEntity<BonusTypeEntity> deleteBonusType(@PathVariable("id") @Min(1) Long id) throws NaturavilaException {
		BonusTypeEntity bonusTypeDB = bonusTypeService.update(id, Boolean.FALSE);
		return ResponseEntity.ok(bonusTypeDB);
	}
	
	@PutMapping(value = "/{id}")
	ResponseEntity<BonusTypeEntity> activateBonusType(@PathVariable("id") @Min(1) Long id) throws NaturavilaException {
		BonusTypeEntity bonusTypeDB = bonusTypeService.update(id, Boolean.TRUE);
		return ResponseEntity.ok(bonusTypeDB);
	}

}
