package com.project.autobackend2.service.impl;

import com.project.autobackend2.entity.Caracteristica;
import com.project.autobackend2.entity.dto.CaracteristicaRequest;
import com.project.autobackend2.entity.dto.CaracteristicaResponse;
import com.project.autobackend2.repository.CaracteristicaRepository;
import com.project.autobackend2.service.CaracteristicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CaracteristicaServiceImpl implements CaracteristicaService {

    private final CaracteristicaRepository caracteristicaRepository;

    @Override
    public List<CaracteristicaResponse> listar() {
        return caracteristicaRepository.findAll().stream()
                .map(c -> CaracteristicaResponse.builder()
                        .id(c.getId())
                        .nombre(c.getNombre())
                        .build())
                .collect(Collectors.toList()); // usa collect para evitar incompatibilidad
    }

    @Override
    public CaracteristicaResponse crear(CaracteristicaRequest request) {
        Caracteristica c = Caracteristica.builder()
                .nombre(request.getNombre())
                .build();

        Caracteristica guardada = caracteristicaRepository.save(c);

        return CaracteristicaResponse.builder()
                .id(guardada.getId())
                .nombre(guardada.getNombre())
                .build();
    }

}