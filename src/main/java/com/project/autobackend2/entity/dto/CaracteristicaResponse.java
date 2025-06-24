package com.project.autobackend2.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaracteristicaResponse {
    private Long id;
    private String nombre;
}