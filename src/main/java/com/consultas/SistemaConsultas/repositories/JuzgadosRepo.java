package com.consultas.SistemaConsultas.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consultas.SistemaConsultas.entities.Juzgados;

@Repository
public interface JuzgadosRepo extends JpaRepository<Juzgados, Long> {
	Optional<Juzgados> findByIdJuzgados(Long idJuzgados);
	Optional<Juzgados> findBydenominacionJuzgados(String denominacionJuzgados);
}
