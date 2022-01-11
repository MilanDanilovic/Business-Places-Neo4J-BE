package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Firma;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.FirmaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FirmaService {

    private FirmaRepository firmaRepository;

    public FirmaService(FirmaRepository firmaRepository) {
        this.firmaRepository = firmaRepository;
    }

    public Collection<Firma>getAll() {
        return firmaRepository.getAllFirma();
    }
}
