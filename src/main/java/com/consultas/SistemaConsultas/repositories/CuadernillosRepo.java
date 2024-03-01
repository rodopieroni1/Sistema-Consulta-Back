package com.consultas.SistemaConsultas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consultas.SistemaConsultas.entities.Cuadernillos;

@Repository
public interface CuadernillosRepo extends JpaRepository<Cuadernillos, Long> {

	List<Cuadernillos> findByIdCuadernillo(Long idCuadernillo);
	Optional<Cuadernillos> findByDenominacionCuadernillo(String denominacionCuadernillo);
	
	Optional<Cuadernillos> findByTipoCuadernillo(String tipoCuadernillo);
	Optional<Cuadernillos> deleteBydenominacionCuadernillo(String denominacionCuadernillo);
}
