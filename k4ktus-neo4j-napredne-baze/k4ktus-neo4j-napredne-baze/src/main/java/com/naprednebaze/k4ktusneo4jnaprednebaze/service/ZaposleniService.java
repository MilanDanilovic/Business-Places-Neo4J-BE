package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.ZaposleniRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ZaposleniService {

    private ZaposleniRepository zaposleniRepository;

    public ZaposleniService(ZaposleniRepository zaposleniRepository) {
        this.zaposleniRepository = zaposleniRepository;
    }

    public Collection<Zaposleni> getAll() {
        return zaposleniRepository.getAllZaposleni();
    }
}
