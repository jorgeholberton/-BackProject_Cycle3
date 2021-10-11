package com.unab.imc.paciente.service.serviceImpl;

import com.unab.imc.exception.NoDataFoundException;
import com.unab.imc.exception.UsuarioExistException;
import com.unab.imc.paciente.component.PacienteMapper2;
import com.unab.imc.paciente.dto.PacienteDto;
import com.unab.imc.paciente.repo.PacienteRepository;
import com.unab.imc.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    PacienteMapper2 pacienteMapper2;

    @Autowired
    PacienteRepository pacienteRepository;
    @Override
    public PacienteDto add(PacienteDto pacienteDto) {
        var paciente = pacienteMapper2.dtoToModel(pacienteDto);
        if (pacienteRepository.findByNombre(paciente.getNombre()) != null) {
            throw new UsuarioExistException("el usuario " + paciente.getNombre() + " ya existe.");
        }
        return pacienteMapper2.modelToDto(pacienteRepository.save(paciente));
    }

    @Override
    public List<PacienteDto> getAll() {
        var pacientes = pacienteRepository.findAll();
        if (pacientes.isEmpty()) {
            throw new NoDataFoundException("No se encontraron pacientes");
        }
        return pacienteMapper2.listModelToDto(pacientes);
    }

    @Override
    public PacienteDto getByNombre(PacienteDto pacienteDto) {
        var paciente = pacienteMapper2.dtoToModel(pacienteDto);
        var pacienteBuscado = pacienteRepository.findByNombre(paciente.getNombre());
        if (pacienteBuscado == null) {
            throw new NoDataFoundException("El rol " + pacienteDto.getNombre() + " no se encontro");
        }
        return pacienteMapper2.modelToDto(pacienteRepository.findByNombre(paciente.getNombre()));
    }

    @Override
    public PacienteDto getById(PacienteDto pacienteDto) {
        var paciente = pacienteRepository.getById(pacienteDto.getCodigo());
        if (pacienteDto == null) {
            throw new NoDataFoundException("El rol " + pacienteDto.getCodigo() + " no se encontro");
        }
        return pacienteMapper2.modelToDto(paciente);
    }

    @Override
    public PacienteDto update(int id, PacienteDto pacienteDto) {

        if (pacienteRepository.getById(pacienteDto.getCodigo()) == null) {
            throw new NoDataFoundException("El rol con ID:" + pacienteDto.getCodigo() + " no se encontro");
        }
        var paciente = pacienteMapper2.dtoToModel(pacienteDto);
        return pacienteMapper2.modelToDto(pacienteRepository.save(paciente));
    }

    @Override
    public void delete(int id) {
        var paciente = pacienteRepository.getById(id);
        System.out.println(paciente.getNombre() + paciente.getNombre());
        if (paciente == null) {
            throw new NoDataFoundException("El rol con ID: " + id + " no se encontro");
        }
        pacienteRepository.deleteById(id);

    }
}
