package com.unab.imc.informacion.component;

import com.unab.imc.informacion.dto.InformacionDto;
import com.unab.imc.informacion.model.Informacion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//DependenciaDTO->ID copielo Dependencia->id

@Component
public class InformacionMapper {

    public InformacionDto modelToDto(Informacion informacion){
        var rolDto= new InformacionDto();
        BeanUtils.copyProperties(informacion, rolDto);
        return rolDto;
    }

    public List<InformacionDto> listModelToDto(List<Informacion> informacions){
        List<InformacionDto> informacionDtos = new ArrayList<>();
        for (Informacion informacion : informacions
        ) {
            informacionDtos.add(modelToDto(informacion));
        }
        return informacionDtos;
    }

    public Informacion dtoToModel(InformacionDto informacionDto){
        var rol= new Informacion();
        BeanUtils.copyProperties(informacionDto, rol);
        return rol;
    }
}
