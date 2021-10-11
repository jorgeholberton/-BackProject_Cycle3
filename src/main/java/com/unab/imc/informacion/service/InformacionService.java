package com.unab.imc.informacion.service;


import com.unab.imc.informacion.dto.InformacionDto;

import java.util.List;

public interface InformacionService {

    InformacionDto add(InformacionDto informacionDto);

    List<InformacionDto> getAll();

    InformacionDto getById(InformacionDto informacionDto);

    InformacionDto update(String id, InformacionDto informacionDto);

    void delete(String id);


}
