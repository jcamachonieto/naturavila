package com.naturavila.service;

import java.util.List;

import com.naturavila.entity.TicketEntity;
import com.naturavila.exception.NaturavilaException;

public interface TicketService {

	List<TicketEntity> findByUser(Long idUser);
	
	List<TicketEntity> findByBonus(Long idBonus);
	
	TicketEntity create(Boolean gift, String userIdentifies) throws NaturavilaException;
	
	List<TicketEntity> createFromBonus(Boolean gift, String userIdentifies, Long idbonus) throws NaturavilaException;
	
	TicketEntity consume(Long id) throws NaturavilaException;

}
