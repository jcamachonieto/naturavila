package com.naturavila.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NaturavilaException extends Exception { 

	private static final long serialVersionUID = 1L;
	public String msg;
	
}
