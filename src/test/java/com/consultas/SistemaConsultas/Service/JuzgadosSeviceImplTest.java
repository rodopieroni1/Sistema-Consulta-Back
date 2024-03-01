package com.consultas.SistemaConsultas.Service;

import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.entities.Juzgados;
import com.consultas.SistemaConsultas.repositories.JuzgadosRepo;
import com.consultas.SistemaConsultas.services.impl.JuzgadosServiceImpl;

public class JuzgadosSeviceImplTest {
	public static final Juzgados JUZGADOS= new Juzgados();
	public static final long JUZGADOS_ID = 1L;
	public static final String DENOMINACION_JUZGADO = "Insumos";

	
	@Mock
	JuzgadosRepo juzgadosRepo;
	
	@InjectMocks
	JuzgadosServiceImpl juzgadosServiceImpl;
	
	@Before
	public void init() throws ConsultasExceptions{
		MockitoAnnotations.openMocks(this);
		JUZGADOS. setIdJuzgados(JUZGADOS_ID);
		JUZGADOS.setDenominacionJuzgados(DENOMINACION_JUZGADO);
	}
	
	@Test
	public void getJuzgadosByidTest()throws ConsultasExceptions{
		Mockito.when(juzgadosRepo.findById(JUZGADOS_ID)).thenReturn(Optional.of(JUZGADOS));
		juzgadosServiceImpl.getJuzgadosByid(JUZGADOS_ID);
	}
	
	@Test(expected = ConsultasExceptions.class)
	public void getJuzgadosByidTestError()throws ConsultasExceptions{
		Mockito.when(juzgadosRepo.findById(JUZGADOS_ID)).thenReturn(Optional.empty());
		juzgadosServiceImpl.getJuzgadosByid(JUZGADOS_ID);
		fail();
	}
	
	@Test
	public void getJuzgadosByDenominacionTest()throws ConsultasExceptions{
		Mockito.when(juzgadosRepo.findBydenominacionJuzgados(DENOMINACION_JUZGADO)).thenReturn(Optional.of(JUZGADOS));
		juzgadosServiceImpl.getJuzgadosBydenominacion(DENOMINACION_JUZGADO);
	}
	
	@Test(expected = ConsultasExceptions.class)
	public void getJuzgadosByDenominacionTestError()throws ConsultasExceptions{
		Mockito.when(juzgadosRepo.findBydenominacionJuzgados(DENOMINACION_JUZGADO)).thenReturn(Optional.empty());
		juzgadosServiceImpl.getJuzgadosBydenominacion(DENOMINACION_JUZGADO);
		fail();
	}
}
