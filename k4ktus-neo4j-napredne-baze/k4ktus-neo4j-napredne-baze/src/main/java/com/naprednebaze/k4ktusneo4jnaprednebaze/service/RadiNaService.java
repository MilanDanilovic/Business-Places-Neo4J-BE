package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.RadiNaRepository;
import org.springframework.stereotype.Service;

@Service
public class RadiNaService {

    private RadiNaRepository radiNaRepository;

    public RadiNaService(RadiNaRepository radiNaRepository) {
        this.radiNaRepository = radiNaRepository;
    }
}
