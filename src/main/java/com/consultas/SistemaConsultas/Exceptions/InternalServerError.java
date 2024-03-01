package com.consultas.SistemaConsultas.Exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.consultas.SistemaConsultas.dto.ErrorDTO;

public class InternalServerError extends ConsultasExceptions {

	private static final long serialVersionUID = 1L;

	public InternalServerError(String code, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	
	public InternalServerError(String code, String message, ErrorDTO data) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}

}
