package com.project.autobackend2.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SucursalResponse {
    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
}