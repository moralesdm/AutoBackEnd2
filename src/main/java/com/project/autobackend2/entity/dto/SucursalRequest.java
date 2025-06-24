package com.project.autobackend2.entity.dto;

import lombok.Data;

@Data
public class SucursalRequest {
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
}