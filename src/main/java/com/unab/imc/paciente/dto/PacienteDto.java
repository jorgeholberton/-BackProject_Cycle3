package com.unab.imc.paciente.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PacienteDto implements Serializable {


    private int codigo;
    private int cod_dependencia;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private int telefono;
    private int codigo_rol;

    public PacienteDto() {
    }
}
