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
import com.consultas.SistemaConsultas.Json.CreateJuzgadosRest;
import com.consultas.SistemaConsultas.Json.JuzgadosRest;
import com.consultas.SistemaConsultas.entities.Juzgados;
import com.consultas.SistemaConsultas.repositories.ExpedientesJuzgadosRepo;
import com.consultas.SistemaConsultas.repositories.JuzgadosRepo;
import com.consultas.SistemaConsultas.services.JuzgadosService;

@Service
public class JuzgadosServiceImpl implements JuzgadosService {
	private static final Logger LOGGER = LoggerFactory.getLogger(JuzgadosServiceImpl.class);
	public static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	JuzgadosRepo juzgadosRepo;
	
	@Autowired
	ExpedientesJuzgadosRepo expedientesJuzgadosRepo; 

	@Override
	public String createJuzgados(CreateJuzgadosRest createJuzgadosRest) throws ConsultasExceptions {
		final Juzgados juzgados = new Juzgados();		
		juzgados.setDenominacionJuzgados(createJuzgadosRest.getDenominacionJuzgados());
		juzgados.setIdJuzgados(createJuzgadosRest.getIdJuzgados());
		try {
			juzgadosRepo.save(juzgados);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerError("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return null;
	}

	public JuzgadosRest getJuzgadosByid(Long idJuzgados) throws ConsultasExceptions {
		return modelMapper.map(getJuzgadosEntity(idJuzgados), JuzgadosRest.class);
		// mapear la entidad Expediente a la clase JuzgadosRest
	}
	
	public Juzgados getJuzgadosEntity(Long idJuzgados) throws ConsultasExceptions {
		return juzgadosRepo.findById(idJuzgados)
				.orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "JUZGADO_NOT_FOUND"));
	}
	
	public JuzgadosRest getJuzgadosBydenominacion(String denominacionJuzgados) throws ConsultasExceptions {
		return modelMapper.map(getJuzgadosEntityDenominacionJuzgados(denominacionJuzgados), JuzgadosRest.class);
	}

	
	public Juzgados getJuzgadosEntityDenominacionJuzgados(String denominacionJuzgados) throws ConsultasExceptions {
		return juzgadosRepo.findBydenominacionJuzgados(denominacionJuzgados)
				.orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "EXPEDIENTE_NOT_FOUND"));
	}
	
	@Override
	public String updateJuzgados(Juzgados juzgados , Long idJuzgados) throws ConsultasExceptions {
		List<Juzgados> list = new ArrayList<>();
		try {
			Optional<Juzgados> juzgadoBuscado = juzgadosRepo.findByIdJuzgados(idJuzgados);
			if(juzgadoBuscado.isPresent()) {
				juzgadoBuscado.get().setIdJuzgados(juzgados.getIdJuzgados());
				juzgadoBuscado.get().setDenominacionJuzgados(juzgados.getDenominacionJuzgados());
				Juzgados juzgadosActualizado = juzgadosRepo.save( juzgadoBuscado.get() );
				list.add(juzgadosActualizado);
				}
	} catch (Exception e) {
		e.getStackTrace();
	}
		return null;

	}

	
	@Override
	public JuzgadosRest deleteJuzgadosByDenominacion(String denominacionJuzgados) throws ConsultasExceptions {
		Optional<Juzgados> juzgadoBuscado = juzgadosRepo.findBydenominacionJuzgados(denominacionJuzgados);
		try {
			juzgadosRepo.deleteById(juzgadoBuscado.get().getIdJuzgados());
			System.out.println("juzgadoBuscado.get().getIdJuzgados()"+ juzgadoBuscado.get().getIdJuzgados());

			} catch (Exception e) {
				System.out.println("Nada");

				return null;
		}
		return null;
	}
	
}
