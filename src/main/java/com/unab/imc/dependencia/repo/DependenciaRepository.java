package com.unab.imc.dependencia.repo;

import com.unab.imc.dependencia.model.Dependencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

    Dependencia findByNombre(String nombre);
}
