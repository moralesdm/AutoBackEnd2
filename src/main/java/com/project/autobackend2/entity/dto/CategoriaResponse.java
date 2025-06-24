package com.project.autobackend2.entity.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CategoriaResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
}