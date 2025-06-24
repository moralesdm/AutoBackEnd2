package com.project.autobackend2.service;

import com.project.autobackend2.entity.dto.SucursalRequest;
import com.project.autobackend2.entity.dto.SucursalResponse;

import java.util.List;

public interface SucursalService {
    List<SucursalResponse> listar();
    SucursalResponse obtener(Long id);
    SucursalResponse crear(SucursalRequest request);
    SucursalResponse actualizar(Long id, SucursalRequest request);
    void eliminar(Long id);
}
