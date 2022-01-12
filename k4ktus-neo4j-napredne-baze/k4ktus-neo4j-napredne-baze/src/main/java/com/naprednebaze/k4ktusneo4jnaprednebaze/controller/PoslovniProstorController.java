package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.PoslovniProstorDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.PoslovniProstor;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.PoslovniProstorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/prostor")
public class PoslovniProstorController {

    private final PoslovniProstorService poslovniProstorService;

    public PoslovniProstorController(PoslovniProstorService poslovniProstorService) {
        this.poslovniProstorService = poslovniProstorService;
    }

    @GetMapping(
            value = "/getAll",
            produces = {"application/json"}
    )
    public Collection<PoslovniProstor> getAll() {
        return poslovniProstorService.getAll();
    }

    @PostMapping(
            value = "/addPoslovniProstor",
            produces = {"application/json"}
    )
    public HttpStatus addPoslovniProstor(@RequestBody(required = true) PoslovniProstorDTO poslovniProstorDTO) {
        try {
            poslovniProstorService.addPoslovniProstor(poslovniProstorDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
