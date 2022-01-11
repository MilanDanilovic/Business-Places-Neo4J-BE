package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.service.KancelarijaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/kancelarija")
public class KancelarijaController {

    private final KancelarijaService kancelarijaService;

    public KancelarijaController(KancelarijaService kancelarijaService) {
        this.kancelarijaService = kancelarijaService;
    }
}
