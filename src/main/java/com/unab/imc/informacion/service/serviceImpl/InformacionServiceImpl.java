package com.unab.imc.informacion.service.serviceImpl;

import com.unab.imc.exception.NoDataFoundException;
import com.unab.imc.exception.UsuarioExistException;
import com.unab.imc.informacion.component.InformacionMapper;
import com.unab.imc.informacion.dto.InformacionDto;
import com.unab.imc.informacion.repo.InformacionRepository;
import com.unab.imc.informacion.service.InformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionServiceImpl implements InformacionService {

    @Autowired
    InformacionMapper informacionMapper;

    @Autowired
    InformacionRepository informacionRepository;

    @Override
    public InformacionDto add(InformacionDto informacionDto) {
        var informacion = informacionMapper.dtoToModel(informacionDto);
        if (!informacionRepository.findById(informacion.getPaciente()).isEmpty()) {
            throw new UsuarioExistException("el usuario " + (informacion.getPaciente() + " ya existe."));
        }
        return informacionMapper.modelToDto(informacionRepository.save(informacion));
    }

    @Override
    public List<InformacionDto> getAll() {
        var informacions = informacionRepository.findAll();
        if (informacions.isEmpty()) {
            throw new NoDataFoundException("No se encontraron usuarios");
        }
        return informacionMapper.listModelToDto(informacions);
    }

    @Override
    public InformacionDto getById(InformacionDto informacionDto) {
        var informacion = informacionRepository.getById(informacionDto.getPaciente());
        if (informacionDto == null) {
            throw new NoDataFoundException("El rol " + informacionDto.getCod_paciente() + " no se encontro");
        }
        return informacionMapper.modelToDto(informacion);
    }

    @Override
    public InformacionDto update(String id, InformacionDto informacionDto) {
        System.out.println(informacionRepository.getById(informacionDto.getPaciente()));
        if (informacionRepository.getById(informacionDto.getPaciente()) == null) {
            throw new NoDataFoundException("El rol con ID:" + informacionDto.getCod_paciente() + " no se encontro");
        }
        var rol = informacionMapper.dtoToModel(informacionDto);
        return informacionMapper.modelToDto(informacionRepository.save(rol));
    }

    @Override
    public void delete(String id) {
        var rol = informacionRepository.getById(id);
        System.out.println(rol.getPaciente() + rol.getCod_paciente());
        if (rol == null) {
            throw new NoDataFoundException("El rol con ID: " + id + " no se encontro");
        }
        informacionRepository.deleteById(id);

    }
}
