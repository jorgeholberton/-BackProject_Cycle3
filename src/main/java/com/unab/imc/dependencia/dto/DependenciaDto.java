package com.unab.imc.dependencia.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class DependenciaDto implements Serializable {


    private int codigo_dependencia;

    private String nombre;

    public DependenciaDto() {
    }
}
