package com.project.autobackend2.service.impl;

import com.project.autobackend2.entity.Sucursal;
import com.project.autobackend2.entity.dto.SucursalRequest;
import com.project.autobackend2.entity.dto.SucursalResponse;
import com.project.autobackend2.repository.SucursalRepository;
import com.project.autobackend2.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    @Override
    public List<SucursalResponse> listar() {
        return sucursalRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public SucursalResponse obtener(Long id) {
        Sucursal s = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        return mapToResponse(s);
    }

    @Override
    public SucursalResponse crear(SucursalRequest request) {
        Sucursal s = Sucursal.builder()
                .nombre(request.getNombre())
                .direccion(request.getDireccion())
                .ciudad(request.getCiudad())
                .pais(request.getPais())
                .build();

        return mapToResponse(sucursalRepository.save(s));
    }

    @Override
    public SucursalResponse actualizar(Long id, SucursalRequest request) {
        Sucursal s = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        if (request.getNombre() != null && !request.getNombre().isBlank()) {
            s.setNombre(request.getNombre());
        }

        if (request.getDireccion() != null && !request.getDireccion().isBlank()) {
            s.setDireccion(request.getDireccion());
        }

        if (request.getCiudad() != null && !request.getCiudad().isBlank()) {
            s.setCiudad(request.getCiudad());
        }

        if (request.getPais() != null && !request.getPais().isBlank()) {
            s.setPais(request.getPais());
        }

        return mapToResponse(sucursalRepository.save(s));
    }

    @Override
    public void eliminar(Long id) {
        if (!sucursalRepository.existsById(id)) {
            throw new RuntimeException("Sucursal no encontrada");
        }
        sucursalRepository.deleteById(id);
    }

    private SucursalResponse mapToResponse(Sucursal s) {
        return SucursalResponse.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .ciudad(s.getCiudad())
                .pais(s.getPais())
                .build();
    }
}
