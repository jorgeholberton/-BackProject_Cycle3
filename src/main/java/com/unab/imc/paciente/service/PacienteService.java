package com.unab.imc.paciente.service;


import com.unab.imc.paciente.dto.PacienteDto;

import java.util.List;

public interface PacienteService {

    PacienteDto add(PacienteDto pacienteDto);

    List<PacienteDto> getAll();

    PacienteDto getById(PacienteDto pacienteDto);

    PacienteDto getByNombre(PacienteDto pacienteDto);

    PacienteDto update(int id, PacienteDto pacienteDto);

    void delete(int id);


}
