package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.PoslovniProstorRepository;
import org.springframework.stereotype.Service;

@Service
public class PoslovniProstorService {

    private PoslovniProstorRepository poslovniProstorRepository;

    public PoslovniProstorService(PoslovniProstorRepository poslovniProstorRepository) {
        this.poslovniProstorRepository = poslovniProstorRepository;
    }
}
