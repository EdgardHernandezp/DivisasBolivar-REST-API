package com.dreamseeker.controller.exceptions;

public class TasaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pudieron devolver las tasas";
	}
}
