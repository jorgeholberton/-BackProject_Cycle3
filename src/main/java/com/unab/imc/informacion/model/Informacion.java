package com.unab.imc.informacion.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inform_imc_paciente")
@Data
public class Informacion {

    @Id
    @Column(name = "codigo_paciente")
    private String paciente;

    @Column(name = "estatura_paciente")
    private Float estatura;

    @Column(name = "peso_paciente")
    private Float peso;

    @Column(name = "imc_paciente")
    private Float imc;

    @Column(name = "clasificacion_paciente")
    private String clasificacion;

    @Column(name = "recomendacion_paciente")
    private String recomendacion;

    @Column(name = "PACIENTE_codigo_estudiante")
    private String cod_paciente;

}
