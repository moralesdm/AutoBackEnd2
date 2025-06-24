package com.project.autobackend2.service;

import com.project.autobackend2.entity.dto.CaracteristicaRequest;
import com.project.autobackend2.entity.dto.CaracteristicaResponse;

import java.util.List;

public interface CaracteristicaService {
    List<CaracteristicaResponse> listar();
    CaracteristicaResponse crear(CaracteristicaRequest request);
}
