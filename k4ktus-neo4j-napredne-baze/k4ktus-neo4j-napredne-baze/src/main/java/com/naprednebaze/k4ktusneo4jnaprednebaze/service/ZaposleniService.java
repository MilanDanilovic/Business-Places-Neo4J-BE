package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.ZaposleniRepository;
import org.springframework.stereotype.Service;

@Service
public class ZaposleniService {

    private ZaposleniRepository zaposleniRepository;

    public ZaposleniService(ZaposleniRepository zaposleniRepository) {
        this.zaposleniRepository = zaposleniRepository;
    }
}
