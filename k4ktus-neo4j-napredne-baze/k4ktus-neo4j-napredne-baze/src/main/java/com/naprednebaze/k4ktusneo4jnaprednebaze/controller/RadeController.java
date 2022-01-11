package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.service.RadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/rade")
public class RadeController {

    private final RadeService radeService;

    public RadeController(RadeService radeService) {
        this.radeService = radeService;
    }
}
