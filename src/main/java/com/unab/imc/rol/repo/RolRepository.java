package com.unab.imc.rol.repo;

import com.unab.imc.rol.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    Rol findByNombre(String nombre);
}
