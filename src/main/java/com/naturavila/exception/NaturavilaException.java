package com.naturavila.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NaturavilaException extends Exception { 

	private static final long serialVersionUID = 1L;
	public String msg;
	
}
