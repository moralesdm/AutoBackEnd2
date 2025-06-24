package com.project.autobackend2.service.impl;

import com.project.autobackend2.entity.Categoria;
import com.project.autobackend2.entity.dto.CategoriaRequest;
import com.project.autobackend2.entity.dto.CategoriaResponse;
import com.project.autobackend2.repository.CategoriaRepository;
import com.project.autobackend2.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaResponse> listarCategorias() {
        return categoriaRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CategoriaResponse obtenerCategoriaPorId(Long id) {
        Categoria c = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        return mapToResponse(c);
    }

    @Override
    public CategoriaResponse crearCategoria(CategoriaRequest request) {
        Categoria c = Categoria.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .build();

        return mapToResponse(categoriaRepository.save(c));
    }

    @Override
    public CategoriaResponse actualizarCategoria(Long id, CategoriaRequest request) {
        Categoria c = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        c.setNombre(request.getNombre());
        c.setDescripcion(request.getDescripcion());
        c.setPrecio(request.getPrecio());

        return mapToResponse(categoriaRepository.save(c));
    }

    @Override
    public void eliminarCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoría no encontrada");
        }
        categoriaRepository.deleteById(id);
    }

    private CategoriaResponse mapToResponse(Categoria c) {
        return CategoriaResponse.builder()
                .id(c.getId())
                .nombre(c.getNombre())
                .descripcion(c.getDescripcion())
                .precio(c.getPrecio())
                .build();
    }
}