package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.service.IznajmljujeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/iznajmljuje")
public class IznajmljujeController {

    private final IznajmljujeService iznajmljujeService;

    public IznajmljujeController(IznajmljujeService iznajmljujeService) {
        this.iznajmljujeService = iznajmljujeService;
    }
}
