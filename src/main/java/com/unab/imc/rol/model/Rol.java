package com.unab.imc.rol.model;

import com.unab.imc.paciente.model.Paciente;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    private int rol_id;

    @Column(name = "rol_nombre")
    private String nombre;


    public Rol() {
    }
}
