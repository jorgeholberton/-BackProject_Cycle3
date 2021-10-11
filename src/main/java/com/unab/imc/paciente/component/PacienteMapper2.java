package com.unab.imc.paciente.component;

import com.unab.imc.paciente.dto.PacienteDto;
import com.unab.imc.paciente.model.Paciente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//DependenciaDTO->ID copielo Dependencia->id

@Component
public class PacienteMapper2 {

    public PacienteDto modelToDto(Paciente paciente){
        var rolDto= new PacienteDto();
        BeanUtils.copyProperties(paciente, rolDto);
        return rolDto;
    }

    public List<PacienteDto> listModelToDto(List<Paciente> pacientes){
        List<PacienteDto> pacienteDtos = new ArrayList<>();
        for (Paciente paciente : pacientes
        ) {
            pacienteDtos.add(modelToDto(paciente));
        }
        return pacienteDtos;
    }

    public Paciente dtoToModel(PacienteDto pacienteDto){
        var rol= new Paciente();
        BeanUtils.copyProperties(pacienteDto, rol);
        return rol;
    }
}
