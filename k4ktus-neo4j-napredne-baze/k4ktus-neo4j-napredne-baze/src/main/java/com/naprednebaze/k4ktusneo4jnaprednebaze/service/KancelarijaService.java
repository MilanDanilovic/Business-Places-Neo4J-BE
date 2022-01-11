package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.KanceralijaRepository;
import org.springframework.stereotype.Service;

@Service
public class KancelarijaService {

    private KanceralijaRepository kanceralijaRepository;

    public KancelarijaService(KanceralijaRepository kanceralijaRepository) {
        this.kanceralijaRepository = kanceralijaRepository;
    }
}
