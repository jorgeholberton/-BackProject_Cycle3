package com.unab.imc.rol.component;

import com.unab.imc.rol.dto.RolDto;
import com.unab.imc.rol.model.Rol;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//DependenciaDTO->ID copielo Dependencia->id

@Component
public class RolMapper {

    public RolDto modelToDto(Rol rol){
        var rolDto= new RolDto();
        BeanUtils.copyProperties(rol, rolDto);
        return rolDto;
    }

    public List<RolDto> listModelToDto(List<Rol> rols){
        List<RolDto> rolDtos = new ArrayList<>();
        for (Rol rol : rols
        ) {
            rolDtos.add(modelToDto(rol));
        }
        return rolDtos;
    }

    public Rol dtoToModel(RolDto rolDto){
        var rol= new Rol();
        BeanUtils.copyProperties(rolDto, rol);
        return rol;
    }
}
