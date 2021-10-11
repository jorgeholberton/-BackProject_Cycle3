package com.unab.imc.rol.service;


import com.unab.imc.rol.dto.RolDto;

import java.util.List;

public interface RolService {

    RolDto add(RolDto rolDto);

    List<RolDto> getAll();

    RolDto getById(RolDto rolDto);

    RolDto getByNombre(RolDto rolDto);

    RolDto update(int id, RolDto rolDto);

    void delete(int id);


}
