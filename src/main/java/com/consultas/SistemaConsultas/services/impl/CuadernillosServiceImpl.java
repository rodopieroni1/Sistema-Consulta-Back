package com.consultas.SistemaConsultas.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Exceptions.InternalServerError;
import com.consultas.SistemaConsultas.Exceptions.NotFoundExceptions;
import com.consultas.SistemaConsultas.Json.CreateCuadernillosRest;
import com.consultas.SistemaConsultas.Json.CuadernillosRest;
import com.consultas.SistemaConsultas.entities.Cuadernillos;
import com.consultas.SistemaConsultas.entities.Expedientes;
import com.consultas.SistemaConsultas.repositories.CuadernillosRepo;
import com.consultas.SistemaConsultas.repositories.ExpedientesRepo;
import com.consultas.SistemaConsultas.services.CuadernillosService;

@Service
public class CuadernillosServiceImpl implements CuadernillosService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CuadernillosServiceImpl.class);
	public static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	ExpedientesRepo expedientesRepo;
	@Autowired
	CuadernillosRepo cuadernillosRepo;
	/*@Autowired
	CreateExpedientesRest createExpedientesRest;*/
	

	@Override
	public String createCuadernillos(CreateCuadernillosRest createCuadernillosRest) throws ConsultasExceptions {		
		final Expedientes expedientesId = expedientesRepo.findById(createCuadernillosRest.getIdExpediente())
				.orElseThrow(()-> new NotFoundExceptions("EXPEDIENTE_NOT_FOUND","EXPEDIENTE_NOT_FOUND "));		
		final Cuadernillos cuadernillos = new Cuadernillos();
		cuadernillos.setIdCuadernillo(createCuadernillosRest.getIdCuadernillo());
		cuadernillos.setFechaCuadernillo(createCuadernillosRest.getFechaCuadernillo());
		cuadernillos.setTipoCuadernillo(createCuadernillosRest.getTipoCuadernillo());
		cuadernillos.setIdexpediente(expedientesId);
		try {
			cuadernillosRepo.save(cuadernillos);
			
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerError("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		
		return null;
	}

	/*private String generateLocator(Expedientes expedientesId, CreateCuadernillosRest createCuadernillosRest)
			throws ConsultasExceptions {
		return expedientesId.getNumExpediente() + createCuadernillosRest.getDenominacionCuadernillo();
	}*/

	
	public CuadernillosRest getCuadernillosById(Long idCuadernillos) throws ConsultasExceptions {
		return modelMapper.map(getCuadernillosEntityById(idCuadernillos), CuadernillosRest.class);
		// mapear la entidad Expediente a la clase JuzgadosRest
	}
	
	public Cuadernillos getCuadernillosEntityById(Long idCuadernillos) throws ConsultasExceptions {
		return cuadernillosRepo.findById(idCuadernillos).orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "JUZGADO_NOT_FOUND"));
	}
	
	public CuadernillosRest getCuadernillosByDenominacion(String denominacionCuadernillos) throws ConsultasExceptions {
		return modelMapper.map(getCuadernillosEntityByDenominacion(denominacionCuadernillos), CuadernillosRest.class);
	}
	
	public Cuadernillos getCuadernillosEntityByDenominacion(String denominacionCuadernillos) throws ConsultasExceptions {
		return cuadernillosRepo.findByDenominacionCuadernillo(denominacionCuadernillos).orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "CUADERNILLO_NOT_FOUND"));
	}	
	
	
	@Override
	public String updateJuzgados(Cuadernillos cuadernillos, Long idCuadernillos)throws ConsultasExceptions {
			List<Cuadernillos> list = new ArrayList<>();
			try {
			
				Optional<Cuadernillos> cuadernilloBuscado = cuadernillosRepo.findById(idCuadernillos);
				if(cuadernilloBuscado.isPresent()) {
					cuadernilloBuscado.get().setDenominacionCuadernillo(cuadernillos.getDenominacionCuadernillo());
					cuadernilloBuscado.get().setFechaCuadernillo(cuadernillos.getFechaCuadernillo());
					cuadernilloBuscado.get().setMovimientoCuadernillo(cuadernillos.getMovimientoCuadernillo());
					Cuadernillos cuadernilloActualizado = cuadernillosRepo.save(cuadernilloBuscado.get());
					list.add(cuadernilloActualizado);
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return null;
	}
	@Override
	public CuadernillosRest deleteCuadernillosByDenominacion(String denominacionCuadernillos) {
		Optional<Cuadernillos> cuadernilloBuscado = cuadernillosRepo.findByDenominacionCuadernillo(denominacionCuadernillos);
		if(cuadernilloBuscado.isPresent()) {
			cuadernillosRepo.deleteById(cuadernilloBuscado.get().getIdCuadernillo());
		}		
		return null;
	}

	@Override
	public String deleteCuadernillos(String denominacionCuadernillo) throws ConsultasExceptions {
		// TODO Auto-generated method stub
		return null;
	}

}
