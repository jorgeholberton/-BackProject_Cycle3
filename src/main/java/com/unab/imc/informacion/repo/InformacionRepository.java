package com.unab.imc.informacion.repo;

import com.unab.imc.informacion.model.Informacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacionRepository extends JpaRepository<Informacion, String> {


}
