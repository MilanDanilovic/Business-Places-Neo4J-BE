package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.ZaposleniService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/zaposleni")
public class ZaposleniController {

    private final ZaposleniService zaposleniService;

    public ZaposleniController(ZaposleniService zaposleniService) {
        this.zaposleniService = zaposleniService;
    }

    @GetMapping(
            value = "/getAll",
            produces = {"application/json"}
    )
    public Collection<Zaposleni> getAll() {
        return zaposleniService.getAll();
    }
}
