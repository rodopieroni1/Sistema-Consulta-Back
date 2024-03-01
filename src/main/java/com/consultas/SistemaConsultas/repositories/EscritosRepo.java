package com.consultas.SistemaConsultas.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consultas.SistemaConsultas.entities.Escritos;

@Repository
public interface EscritosRepo extends JpaRepository<Escritos, Long> {
	List<Escritos> findByIdEscritos(Long idEscritos);
	Optional<Escritos> findByDescripcionEscritos(String descripcionEscritos);
}
