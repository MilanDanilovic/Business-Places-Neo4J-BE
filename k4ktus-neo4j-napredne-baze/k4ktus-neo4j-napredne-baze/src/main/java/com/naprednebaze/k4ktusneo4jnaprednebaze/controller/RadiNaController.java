package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.service.RadiNaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/radina")
public class RadiNaController {

    private final RadiNaService radiNaService;

    public RadiNaController(RadiNaService radiNaService) {
        this.radiNaService = radiNaService;
    }
}
