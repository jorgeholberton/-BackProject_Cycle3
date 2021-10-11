package com.unab.imc.dependencia.component;

import com.unab.imc.dependencia.dto.DependenciaDto;
import com.unab.imc.dependencia.model.Dependencia;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//DependenciaDTO->ID copielo Dependencia->id

@Component
public class DependenciaMapper {

    public DependenciaDto modelToDto(Dependencia dependencia){
        var dependenciaDto= new DependenciaDto();
        BeanUtils.copyProperties(dependencia, dependenciaDto);
        return dependenciaDto;
    }

    public List<DependenciaDto> listModelToDto(List<Dependencia> dependencias){
        List<DependenciaDto> dependenciaDtos = new ArrayList<>();
        for (Dependencia dependencia : dependencias
        ) {
            dependenciaDtos.add(modelToDto(dependencia));
        }
        return dependenciaDtos;
    }

    public Dependencia dtoToModel(DependenciaDto dependenciaDto){
        var dependencia= new Dependencia();
        BeanUtils.copyProperties(dependenciaDto, dependencia);
        return dependencia;
    }
}
