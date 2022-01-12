package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.KancelarijaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/kancelarija")
public class KancelarijaController {

    private final KancelarijaService kancelarijaService;

    public KancelarijaController(KancelarijaService kancelarijaService) {
        this.kancelarijaService = kancelarijaService;
    }

    @GetMapping(
            value = "/getAll",
            produces = {"application/json"}
    )
    public Collection<Kancelarija> getAll() {
        return kancelarijaService.getAll();
    }

    @GetMapping(
            value = "/getEmpty",
            produces = {"application/json"}
    )
    public Collection<Kancelarija> getEmpty() {
        return kancelarijaService.getEmpty();
    }

    @GetMapping(
            value = "/getOccupied",
            produces = {"application/json"}
    )
    public Collection<Kancelarija> getOccupied() {
        return kancelarijaService.getOccupied();
    }
}
