package com.unab.imc.informacion.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InformacionDto implements Serializable {


    private String paciente;

    private Float estatura;

    private Float peso;

    private Float imc;

    private String clasificacion;

    private String recomendacion;

    private String cod_paciente;
}
