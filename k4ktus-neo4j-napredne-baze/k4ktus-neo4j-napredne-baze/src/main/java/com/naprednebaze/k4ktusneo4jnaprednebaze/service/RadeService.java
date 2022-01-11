package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.RadeRepository;
import org.springframework.stereotype.Service;

@Service
public class RadeService {

    private RadeRepository radeRepository;

    public RadeService(RadeRepository radeRepository) {
        this.radeRepository = radeRepository;
    }
}
