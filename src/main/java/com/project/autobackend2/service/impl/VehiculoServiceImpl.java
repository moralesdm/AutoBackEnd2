package com.project.autobackend2.service.impl;

import com.project.autobackend2.entity.Categoria;
import com.project.autobackend2.entity.Sucursal;
import com.project.autobackend2.entity.Vehiculo;
import com.project.autobackend2.entity.dto.VehiculoRequest;
import com.project.autobackend2.entity.dto.VehiculoResponse;
import com.project.autobackend2.repository.CategoriaRepository;
import com.project.autobackend2.repository.SucursalRepository;
import com.project.autobackend2.repository.VehiculoRepository;
import com.project.autobackend2.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final CategoriaRepository categoriaRepository;
    private final SucursalRepository sucursalRepository;

    @Override
    public VehiculoResponse crearVehiculo(VehiculoRequest request) {
    Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

    Sucursal sucursal = sucursalRepository.findById(request.getSucursalId())
            .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
    Vehiculo vehiculo = Vehiculo.builder()
            .marca(request.getMarca())
            .modelo(request.getModelo())
            .tipo(request.getTipo())
            .anio(request.getAnio())
            .color(request.getColor())
            .categoria(categoria)
            .sucursal(sucursal)
            .estado(true)
            .build();

    vehiculoRepository.save(vehiculo);

    return VehiculoResponse.builder()
            .id(vehiculo.getId())
            .marca(vehiculo.getMarca())
            .modelo(vehiculo.getModelo())
            .tipo(vehiculo.getTipo())
            .anio(vehiculo.getAnio())
            .color(vehiculo.getColor())
            .disponible(vehiculo.getEstado())
            .categoria(categoria.getNombre())
            .precioPorDia(categoria.getPrecio())
            .sucursal(sucursal.getNombre())
            .build();
    }

    @Override
    public List<VehiculoResponse> listarVehiculos() {
        return vehiculoRepository.findAll().stream()
                .map(vehiculo -> VehiculoResponse.builder()
                        .id(vehiculo.getId())
                        .marca(vehiculo.getMarca())
                        .modelo(vehiculo.getModelo())
                        .tipo(vehiculo.getTipo())
                        .anio(vehiculo.getAnio())
                        .color(vehiculo.getColor())
                        .disponible(vehiculo.getEstado())
                        .categoria(vehiculo.getCategoria().getNombre())
                        .precioPorDia(vehiculo.getCategoria().getPrecio())
                        .sucursal(vehiculo.getSucursal().getNombre())
                        .build())
                .toList();
    }
}