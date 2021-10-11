package com.unab.imc.paciente.model;

import com.unab.imc.dependencia.model.Dependencia;
import com.unab.imc.rol.model.Rol;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PACIENTE")
@Data
public class Paciente {

    @Id
    @Column(name = "codigo_paciente")
    private int codigo;

    @Column(name = "codigo_dependencia")
    private int cod_dependencia;

    @Column(name = "nomb_paciente")
    private String nombre;

    @Column(name = "apellido_paciente")
    private String apellido;

    @Column(name = "direccion_paciente")
    private String direccion;

    @Column(name = "correo_paciente")
    private String correo;

    @Column(name = "telefono_paciente")
    private int telefono;

    @Column(name = "ROL_rol_id")
    private int codigo_rol;


}
