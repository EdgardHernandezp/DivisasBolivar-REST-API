package com.dreamseeker.controller.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pudo devolver el recurso";
	}
}
