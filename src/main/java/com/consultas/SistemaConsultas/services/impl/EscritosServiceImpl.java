package com.consultas.SistemaConsultas.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Exceptions.InternalServerError;
import com.consultas.SistemaConsultas.Exceptions.NotFoundExceptions;
import com.consultas.SistemaConsultas.Json.CreateEscritosRest;
import com.consultas.SistemaConsultas.entities.Escritos;
import com.consultas.SistemaConsultas.entities.Expedientes;
import com.consultas.SistemaConsultas.entities.Juzgados;
import com.consultas.SistemaConsultas.repositories.EscritosRepo;
import com.consultas.SistemaConsultas.repositories.ExpedientesRepo;
import com.consultas.SistemaConsultas.services.CuadernillosService;
import com.consultas.SistemaConsultas.services.EscritosService;

@Service
public class EscritosServiceImpl implements EscritosService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EscritosServiceImpl.class);
	@Autowired
	ExpedientesRepo expedientesRepo;
	@Autowired
	EscritosRepo escritosRepo;
	
	@Override
	public String crearEscritos(CreateEscritosRest createEscritosRest) throws ConsultasExceptions {
		final Expedientes expedientesId = expedientesRepo.findById(createEscritosRest.getIdExpediente())
				.orElseThrow(()-> new NotFoundExceptions("EXPEDIENTE_NOT_FOUND","EXPEDIENTE_NOT_FOUND "));		
		final Escritos escritos = new Escritos();
		escritos.setIdEscritos(createEscritosRest.getIdEscritos());
		escritos.setDescripcionEscritos(createEscritosRest.getDescripcionEscritos());
		escritos.setTituloEscritos(createEscritosRest.getTituloEscritos());
		escritos.setIdexpedientes(expedientesId);
		try {
			escritosRepo.save(escritos);			
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerError("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}		
		return null;
	}
	
	@Override
	public String updateEscritos(Escritos escritos , Long idEscritos) throws ConsultasExceptions {
		List<Escritos> list = new ArrayList<>();
		try {
			Optional<Escritos> escritosBuscado = escritosRepo.findById(idEscritos);
			if(escritosBuscado.isPresent()) {
				escritosBuscado.get().setIdEscritos(escritos.getIdEscritos());
				escritosBuscado.get().setDescripcionEscritos(escritos.getDescripcionEscritos());
				escritosBuscado.get().setTituloEscritos(escritos.getTituloEscritos());
				Escritos escritosActualizado = escritosRepo.save(escritosBuscado.get());		
				list.add(escritosActualizado);
				System.out.println("escritosActualizado"+ list);
				}
	} catch (Exception e) {
		e.getStackTrace();
	}
		return null;

	}

	@Override
	public String deleteEscritos(Escritos escritos, Long idEscritos)throws ConsultasExceptions {
			try {
				Optional<Escritos> escritosBuscado =  escritosRepo.findById(idEscritos);
				if(escritosBuscado.isPresent()) {
					escritosRepo.deleteById(escritosBuscado.get().getIdEscritos());
					System.out.println("escritosBuscado.get().getIdEscritos()"+ escritosBuscado.get().getIdEscritos());

					}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return null;
	}
	
	

}
