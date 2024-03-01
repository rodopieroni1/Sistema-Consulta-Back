package com.consultas.SistemaConsultas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consultas.SistemaConsultas.entities.Escritos;
import com.consultas.SistemaConsultas.entities.ExpedientesJuzgados;

@Repository
public interface ExpedientesJuzgadosRepo extends JpaRepository<ExpedientesJuzgados, Long> {
	Optional<ExpedientesJuzgados>findById(Long idExpedienteJuzgados);  	
	List<ExpedientesJuzgados>findAll();
}
