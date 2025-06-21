package com.project.autobackend2.service;

import com.project.autobackend2.entity.dto.VehiculoRequest;
import com.project.autobackend2.entity.dto.VehiculoResponse;

import java.util.List;

public interface VehiculoService {
    VehiculoResponse crearVehiculo(VehiculoRequest request);
    List<VehiculoResponse> listarVehiculos();
}
