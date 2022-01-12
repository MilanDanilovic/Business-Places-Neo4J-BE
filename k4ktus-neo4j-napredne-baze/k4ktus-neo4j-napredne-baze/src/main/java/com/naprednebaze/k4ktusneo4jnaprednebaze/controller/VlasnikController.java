package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Vlasnik;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.VlasnikService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/vlasnik")
public class VlasnikController {

    private final VlasnikService vlasnikService;

    public VlasnikController(VlasnikService vlasnikService) {
        this.vlasnikService = vlasnikService;
    }

    @GetMapping(
            value = "/getAll",
            produces = {"application/json"}
    )
    public Collection<Vlasnik> getAll() {
        return vlasnikService.getAll();
    }
}
