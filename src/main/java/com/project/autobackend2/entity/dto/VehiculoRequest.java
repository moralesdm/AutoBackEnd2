package com.project.autobackend2.entity.dto;

import lombok.Data;

@Data
public class VehiculoRequest {
    private String marca;
    private String modelo;
    private String tipo;
    private String anio;
    private String color;
    private String imagenUrl;
    private Long categoriaId;
    private Long sucursalId;
}
