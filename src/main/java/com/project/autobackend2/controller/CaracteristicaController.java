package com.project.autobackend2.controller;

import com.project.autobackend2.entity.dto.CaracteristicaRequest;
import com.project.autobackend2.entity.dto.CaracteristicaResponse;
import com.project.autobackend2.service.CaracteristicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos/caracteristicas")
@RequiredArgsConstructor
public class CaracteristicaController {

    private final CaracteristicaService caracteristicaService;

    @GetMapping
    public ResponseEntity<List<CaracteristicaResponse>> listar() {
        return ResponseEntity.ok(caracteristicaService.listar());
    }

    @PostMapping
    public ResponseEntity<CaracteristicaResponse> crear(@RequestBody CaracteristicaRequest request) {
        return new ResponseEntity<>(caracteristicaService.crear(request), HttpStatus.CREATED);
    }
}