package com.consultas.SistemaConsultas.Exceptions;
import java.util.*;
import com.consultas.SistemaConsultas.dto.*;

public class ConsultasExceptions extends Exception {
	private static final long serialVersionUID = 1L;	
	private final String code; //(Por ejemplo "Not found Exceptions")
	private final int responseCode; //(por ejemplo 404)	
	private final List<ErrorDTO> errorList = new ArrayList<>();
	
	public ConsultasExceptions(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public ConsultasExceptions(String code, int responseCode, String message, List<ErrorDTO> errorList) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public List<ErrorDTO> getErrorList() {
		return errorList;
	}
	
}
