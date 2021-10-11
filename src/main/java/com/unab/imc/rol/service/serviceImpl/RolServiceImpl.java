package com.unab.imc.rol.service.serviceImpl;

import com.unab.imc.exception.NoDataFoundException;
import com.unab.imc.exception.UsuarioExistException;
import com.unab.imc.rol.component.RolMapper;
import com.unab.imc.rol.dto.RolDto;
import com.unab.imc.rol.repo.RolRepository;
import com.unab.imc.rol.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolMapper rolMapper;

    @Autowired
    RolRepository rolRepository;

    @Override
    public RolDto add(RolDto rolDto) {
        var rol = rolMapper.dtoToModel(rolDto);
        if (rolRepository.findByNombre(rol.getNombre()) != null) {
            throw new UsuarioExistException("el usuario " + rol.getNombre() + " ya existe.");
        }
        return rolMapper.modelToDto(rolRepository.save(rol));
    }

    @Override
    public List<RolDto> getAll() {
        var roles = rolRepository.findAll();
        if (roles.isEmpty()) {
            throw new NoDataFoundException("No se encontraron usuarios");
        }
        return rolMapper.listModelToDto(roles);
    }

    @Override
    public RolDto getByNombre(RolDto rolDto) {
        var rol = rolMapper.dtoToModel(rolDto);
        var rolBuscado = rolRepository.findByNombre(rol.getNombre());
        if (rolBuscado == null) {
            throw new NoDataFoundException("El rol " + rolDto.getNombre() + " no se encontro");
        }
        return rolMapper.modelToDto(rolRepository.findByNombre(rol.getNombre()));
    }

    @Override
    public RolDto getById(RolDto rolDto) {
        var rol = rolRepository.getById(rolDto.getRol_id());
        if (rolDto == null) {
            throw new NoDataFoundException("El rol " + rolDto.getRol_id() + " no se encontro");
        }
        return rolMapper.modelToDto(rol);
    }

    @Override
    public RolDto update(int id, RolDto rolDto) {

        if (rolRepository.getById(rolDto.getRol_id()) == null) {
            throw new NoDataFoundException("El rol con ID:" + rolDto.getRol_id() + " no se encontro");
        }
        var rol = rolMapper.dtoToModel(rolDto);
        return rolMapper.modelToDto(rolRepository.save(rol));
    }

    @Override
    public void delete(int id) {
        var rol = rolRepository.getById(id);
        System.out.println(rol.getNombre() + rol.getNombre());
        if (rol == null) {
            throw new NoDataFoundException("El rol con ID: " + id + " no se encontro");
        }
        rolRepository.deleteById(id);

    }
}
