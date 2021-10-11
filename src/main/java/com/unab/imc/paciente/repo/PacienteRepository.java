package com.unab.imc.paciente.repo;

import com.unab.imc.paciente.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    Paciente findByNombre(String nombre);
}
