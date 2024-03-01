package com.consultas.SistemaConsultas.Exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import com.consultas.SistemaConsultas.dto.ErrorDTO;

public class NotFoundExceptions extends ConsultasExceptions {

	private static final long serialVersionUID = 1L;

	public NotFoundExceptions(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}
	
	public NotFoundExceptions(String code, String message, ErrorDTO data) {
		super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}
	
	

	
}
