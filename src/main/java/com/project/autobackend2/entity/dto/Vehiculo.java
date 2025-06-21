package com.project.autobackend2.entity.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private String anio;
    private Boolean estado;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Sucursal sucursal;
}
