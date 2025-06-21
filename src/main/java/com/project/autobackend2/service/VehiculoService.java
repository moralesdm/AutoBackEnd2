package com.project.autobackend2.service;

import com.project.autobackend2.entity.dto.VehiculoRequest;
import com.project.autobackend2.entity.dto.VehiculoResponse;
import com.project.autobackend2.entity.dto.VehiculoUpdateRequest;

import java.util.List;

public interface VehiculoService {
    VehiculoResponse crearVehiculo(VehiculoRequest request);
    List<VehiculoResponse> listarVehiculos();
    VehiculoResponse obtenerVehiculoPorId(Long id);
    VehiculoResponse actualizarVehiculo(Long id, VehiculoUpdateRequest request);
    void eliminarVehiculo(Long id); // Soft delete
}
