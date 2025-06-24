package com.project.autobackend2.service;

import com.project.autobackend2.entity.dto.CategoriaRequest;
import com.project.autobackend2.entity.dto.CategoriaResponse;

import java.util.List;

public interface CategoriaService {
    List<CategoriaResponse> listarCategorias();
    CategoriaResponse obtenerCategoriaPorId(Long id);
    CategoriaResponse crearCategoria(CategoriaRequest request);
    CategoriaResponse actualizarCategoria(Long id, CategoriaRequest request);
    void eliminarCategoria(Long id);
}
