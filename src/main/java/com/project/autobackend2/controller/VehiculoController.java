package com.project.autobackend2.controller;

import com.project.autobackend2.entity.dto.VehiculoRequest;
import com.project.autobackend2.entity.dto.VehiculoResponse;
import com.project.autobackend2.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<VehiculoResponse> crearVehiculo(@RequestBody VehiculoRequest request) {
        VehiculoResponse vehiculo = vehiculoService.crearVehiculo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculo);
    }

    @GetMapping
    public ResponseEntity<List<VehiculoResponse>> listarVehiculos() {
        return ResponseEntity.ok(vehiculoService.listarVehiculos());
    }
}