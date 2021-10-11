package com.unab.imc.dependencia.service;


import com.unab.imc.dependencia.dto.DependenciaDto;

import java.util.List;

public interface DependenciaService {

    DependenciaDto add(DependenciaDto dependenciaDto);

    List<DependenciaDto> getAll();

    DependenciaDto getById(DependenciaDto dependenciaDto);

    DependenciaDto getByNombre(DependenciaDto dependenciaDto);

    DependenciaDto update(int id, DependenciaDto dependenciaDto);

    void delete(int id);


}
