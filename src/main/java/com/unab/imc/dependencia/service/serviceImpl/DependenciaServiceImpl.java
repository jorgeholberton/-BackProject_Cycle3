package com.unab.imc.dependencia.service.serviceImpl;

import com.unab.imc.dependencia.component.DependenciaMapper;
import com.unab.imc.dependencia.dto.DependenciaDto;
import com.unab.imc.dependencia.repo.DependenciaRepository;
import com.unab.imc.dependencia.service.DependenciaService;
import com.unab.imc.exception.NoDataFoundException;
import com.unab.imc.exception.UsuarioExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenciaServiceImpl implements DependenciaService {

    @Autowired
    DependenciaMapper dependenciaMapper;

    @Autowired
    DependenciaRepository dependenciaRepository;

    @Override
    public DependenciaDto add(DependenciaDto dependenciaDto) {
        var dependencia = dependenciaMapper.dtoToModel(dependenciaDto);
        if (dependenciaRepository.findByNombre(dependencia.getNombre()) != null) {
            throw new UsuarioExistException("el usuario " + dependencia.getNombre() + " ya existe.");
        }
        return dependenciaMapper.modelToDto(dependenciaRepository.save(dependencia));
    }

    @Override
    public List<DependenciaDto> getAll() {
        var usuarios = dependenciaRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new NoDataFoundException("No se encontraron usuarios");
        }
        return dependenciaMapper.listModelToDto(usuarios);
    }

    @Override
    public DependenciaDto getByNombre(DependenciaDto dependenciaDto) {
        var dependencia = dependenciaMapper.dtoToModel(dependenciaDto);
        var dependenciaBuscada = dependenciaRepository.findByNombre(dependencia.getNombre());
        if (dependenciaBuscada == null) {
            throw new NoDataFoundException("El usuario " + dependenciaDto.getNombre() + " no se encontro");
        }
        return dependenciaMapper.modelToDto(dependenciaRepository.findByNombre(dependencia.getNombre()));
    }

    @Override
    public DependenciaDto getById(DependenciaDto dependenciaDto) {
        var dependencia = dependenciaRepository.getById(dependenciaDto.getCodigo_dependencia());
        if (dependenciaDto == null) {
            throw new NoDataFoundException("El usuario " + dependenciaDto.getCodigo_dependencia() + " no se encontro");
        }
        return dependenciaMapper.modelToDto(dependencia);
    }

    @Override
    public DependenciaDto update(int id, DependenciaDto dependenciaDto) {

        if (dependenciaRepository.getById(dependenciaDto.getCodigo_dependencia()) == null) {
            throw new NoDataFoundException("El usuario con ID:" + dependenciaDto.getCodigo_dependencia() + " no se encontro");
        }
        var usuario = dependenciaMapper.dtoToModel(dependenciaDto);
        return dependenciaMapper.modelToDto(dependenciaRepository.save(usuario));
    }

    @Override
    public void delete(int id) {
        var dependencia = dependenciaRepository.getById(id);
        System.out.println(dependencia.getCodigo_dependencia() + dependencia.getNombre());
        if (dependencia == null) {
            throw new NoDataFoundException("El usuario con ID: " + id + " no se encontro");
        }
        dependenciaRepository.deleteById(id);

    }
}
