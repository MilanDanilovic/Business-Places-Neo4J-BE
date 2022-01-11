package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.SadrziRepository;
import org.springframework.stereotype.Service;

@Service
public class SadrziService {

    private SadrziRepository sadrziRepository;

    public SadrziService(SadrziRepository sadrziRepository) {
        this.sadrziRepository = sadrziRepository;
    }
}
