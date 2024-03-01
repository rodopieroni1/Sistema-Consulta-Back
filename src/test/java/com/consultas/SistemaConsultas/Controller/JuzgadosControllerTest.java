package com.consultas.SistemaConsultas.Controller;

import org.mockito.*;
import org.springframework.boot.test.context.TestComponent;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.JuzgadosRest;
import com.consultas.SistemaConsultas.Response.ConsultasResponse;
import com.consultas.SistemaConsultas.controllers.juzgadosControllers;
import com.consultas.SistemaConsultas.services.JuzgadosService;

public class JuzgadosControllerTest {

	public static final long JUZGADOS_ID = 1L;
	public static final String DENOMINACION_JUZGADO = "jUZGADO pAZ 1";

	public static final String SUCCES_STATUS = "Succes";
	public static final String SUCCES_CODE = "200 OK";
	public static final String OK = "OK";
	public static final JuzgadosRest JUZGADOS_REST = new JuzgadosRest();

	@Mock
	JuzgadosService juzgadosService; // hace que esta clase test funcione como service

	@InjectMocks
	juzgadosControllers juzgadosControllers; // crea una instancia de la clase e injecta el mock creado arriba

	@Before // aquise añaden los metodos a testear
	public void init() throws ConsultasExceptions {
		 MockitoAnnotations.initMocks(this);
		//MockitoAnnotations.openMocks(this);
		System.out.println(MockitoAnnotations.openMocks(this));

		JUZGADOS_REST.setIdJuzgados(JUZGADOS_ID);
		JUZGADOS_REST.setDenominacionJuzgados(DENOMINACION_JUZGADO);
		Mockito.when(juzgadosService.getJuzgadosByid(JUZGADOS_ID)).thenReturn(JUZGADOS_REST);
		Mockito.when(juzgadosService.getJuzgadosBydenominacion(DENOMINACION_JUZGADO)).thenReturn(JUZGADOS_REST);


	}

	@Test
	public void getJuzgadosByIdTest() throws ConsultasExceptions {
		ConsultasResponse<JuzgadosRest> response = juzgadosControllers.getJuzgadosByid(JUZGADOS_ID);
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), JUZGADOS_REST);

	}
	@Test
	public void getJuzgadosByDenominacionTest() throws ConsultasExceptions {
		ConsultasResponse<JuzgadosRest> response = juzgadosControllers.getJuzgadosByDenominacion(DENOMINACION_JUZGADO);
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), JUZGADOS_REST);

	}

}
