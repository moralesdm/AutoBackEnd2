package com.project.autobackend2.controller;

import com.project.autobackend2.entity.dto.SucursalRequest;
import com.project.autobackend2.entity.dto.SucursalResponse;
import com.project.autobackend2.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos/sucursales")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<SucursalResponse>> listar() {
        return ResponseEntity.ok(sucursalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(sucursalService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<SucursalResponse> crear(@RequestBody SucursalRequest request) {
        return new ResponseEntity<>(sucursalService.crear(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalResponse> actualizar(@PathVariable Long id, @RequestBody SucursalRequest request) {
        return ResponseEntity.ok(sucursalService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        sucursalService.eliminar(id);
        return ResponseEntity.ok("Sucursal eliminada correctamente");
    }
}
