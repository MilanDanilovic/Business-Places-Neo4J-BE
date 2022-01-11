package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.service.PoslovniProstorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/prostor")
public class PoslovniProstorController {

    private final PoslovniProstorService poslovniProstorService;

    public PoslovniProstorController(PoslovniProstorService poslovniProstorService) {
        this.poslovniProstorService = poslovniProstorService;
    }
}
