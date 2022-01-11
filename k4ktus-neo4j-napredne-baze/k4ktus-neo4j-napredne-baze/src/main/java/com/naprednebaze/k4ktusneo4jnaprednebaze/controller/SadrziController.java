package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.service.SadrziService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/sadrzi")
public class SadrziController {

    private final SadrziService sadrziService;

    public SadrziController(SadrziService sadrziService) {
        this.sadrziService = sadrziService;
    }
}
