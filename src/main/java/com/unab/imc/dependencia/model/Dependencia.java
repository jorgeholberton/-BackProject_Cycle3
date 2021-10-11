package com.unab.imc.dependencia.model;

import com.unab.imc.paciente.model.Paciente;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dependencia")
@Data
public class Dependencia {

    @Id
    private int codigo_dependencia;

    @Column(name = "nombre_dependencia")
    private String nombre;

    public Dependencia() {
    }
}
