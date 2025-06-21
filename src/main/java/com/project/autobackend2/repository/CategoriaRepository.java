package com.project.autobackend2.repository;

import com.project.autobackend2.entity.dto.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
