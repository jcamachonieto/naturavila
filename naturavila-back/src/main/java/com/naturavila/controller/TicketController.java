package com.naturavila.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturavila.config.JwtProvider;
import com.naturavila.entity.TicketEntity;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.service.TicketService;

@RestController
@RequestMapping("/protected/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@Autowired
	private JwtProvider tokenProvider;

	@GetMapping("/user/{id}")
	public ResponseEntity<List<TicketEntity>> findByUser(@PathVariable("id") @Min(1) Long idUser) {
		return ResponseEntity.ok(ticketService.findByUser(idUser));
	}
	
	@GetMapping("/bonus/{id}")
	public ResponseEntity<List<TicketEntity>> findByBonus(@PathVariable("id") @Min(1) Long idBonus) {
		return ResponseEntity.ok(ticketService.findByBonus(idBonus));
	}
	
	@PostMapping
	ResponseEntity<TicketEntity> buy(HttpServletRequest request) throws NaturavilaException {
		String jwt = tokenProvider.getJwtFromRequest(request);
		String userIdentifier = tokenProvider.getUserUsernameFromJWT(jwt);
		TicketEntity retorno = ticketService.create(Boolean.FALSE, userIdentifier);
		return ResponseEntity.ok(retorno);
	}

}