package com.unab.imc.rol.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolDto implements Serializable {


    private int rol_id;

    private String nombre;

    public RolDto() {
    }
}
