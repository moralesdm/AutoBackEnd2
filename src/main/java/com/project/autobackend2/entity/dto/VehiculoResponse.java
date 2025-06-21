package com.project.autobackend2.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class VehiculoResponse {
    private Long id;
    private String marca;
    private String modelo;
    private String tipo;
    private int anio;
    private String color;
    private boolean disponible;
    private String categoria;
    private BigDecimal precioPorDia; // ← proviene de la categoría
    private String sucursal;
}