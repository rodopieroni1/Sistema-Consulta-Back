package com.consultas.SistemaConsultas.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.consultas.SistemaConsultas.entities.Expedientes;

@Repository
public interface ExpedientesRepo extends JpaRepository<Expedientes, Long> {

	Optional<Expedientes>findById(Long idExpediente);  	
	Optional<Expedientes>findByNumExpediente(String numExpediente);
	
	@Query("SELECT REST FROM Expedientes REST")
	public List<Expedientes> findExpediente();
	
}
