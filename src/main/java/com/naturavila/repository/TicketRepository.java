package com.naturavila.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naturavila.entity.TicketEntity;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long>{
	
	List<TicketEntity> findByUser_Id(Long userId);
	
	List<TicketEntity> findByBonus_Id(Long userId);
	
}
