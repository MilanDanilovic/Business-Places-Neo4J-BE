package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.KancelarijaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KancelarijaService {

    private KancelarijaRepository kancelarijaRepository;

    public KancelarijaService(KancelarijaRepository kancelarijaRepository) {
        this.kancelarijaRepository = kancelarijaRepository;
    }

    public Collection<Kancelarija> getAll() {
        return kancelarijaRepository.getAllKancelarija();
    }

    public Collection<Kancelarija> getEmpty() {
        return kancelarijaRepository.getEmptyKancelarija();
    }

    public Collection<Kancelarija> getOccupied() {
        return kancelarijaRepository.getOccupiedKancelarija();
    }
}
