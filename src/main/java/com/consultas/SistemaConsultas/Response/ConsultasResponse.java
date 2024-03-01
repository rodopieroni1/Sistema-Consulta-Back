package com.consultas.SistemaConsultas.Response;

import java.io.Serializable;

public class ConsultasResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	private String code;
	private String message;
	private T data;
	
	public ConsultasResponse(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
	
	public ConsultasResponse(String status, String code, String message, T data) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final String getCode() {
		return code;
	}

	public final void setCode(String code) {
		this.code = code;
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}

	public final T getData() {
		return data;
	}

	public final void setData(T data) {
		this.data = data;
	}
	
}
