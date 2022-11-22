package com.naturavila.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturavila.entity.BonusEntity;
import com.naturavila.entity.TicketEntity;
import com.naturavila.entity.UserEntity;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.repository.TicketRepository;
import com.naturavila.service.BonusService;
import com.naturavila.service.TicketService;
import com.naturavila.service.UserService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BonusService bonusService;

	@Override
	public List<TicketEntity> findByUser(Long idUser) {
		return ticketRepository.findByUser_Id(idUser);
	}
	
	@Override
	public List<TicketEntity> findByBonus(Long idBonus) {
		return ticketRepository.findByBonus_Id(idBonus);
	}
	
	@Override
	public TicketEntity create(Boolean gift, String userIdentifier) throws NaturavilaException {
		UserEntity user = userService.findByIdentifier(userIdentifier);
		TicketEntity retorno = TicketEntity.builder().gift(gift).user(user).build();
		retorno = ticketRepository.save(retorno);
		return retorno;
	}

	@Override
	public List<TicketEntity> createFromBonus(Boolean gift, String userIdentifier, Long idbonus) throws NaturavilaException {
		UserEntity user = userService.findByIdentifier(userIdentifier);
		BonusEntity bonus = bonusService.findById(idbonus);
		List<TicketEntity> retorno = new ArrayList<>();
		for (int numTickets = 0; numTickets < bonus.getNumTickets(); numTickets++) {
			TicketEntity ticket = TicketEntity.builder().bonus(bonus).gift(gift).user(user).build();
			retorno.add(ticketRepository.save(ticket));
		}
		return retorno;
	}

	@Override
	public TicketEntity consume(Long id) throws NaturavilaException {
		TicketEntity ticket = ticketRepository.findById(id)
				.orElseThrow(() -> new NaturavilaException("Ticket not found with ID :" + id));
		ticket.setConsumed(LocalDateTime.now());
		ticket = ticketRepository.save(ticket);
		return ticket;
	}

}
