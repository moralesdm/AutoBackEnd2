package com.project.autobackend2.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CategoriaRequest {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
}