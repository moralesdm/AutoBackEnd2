package com.project.autobackend2.controller;

import com.project.autobackend2.entity.dto.CategoriaRequest;
import com.project.autobackend2.entity.dto.CategoriaResponse;
import com.project.autobackend2.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listar() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.obtenerCategoriaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> crear(@RequestBody CategoriaRequest request) {
        return new ResponseEntity<>(categoriaService.crearCategoria(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> actualizar(@PathVariable Long id, @RequestBody CategoriaRequest request) {
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.ok("Categoría eliminada correctamente");
    }
}