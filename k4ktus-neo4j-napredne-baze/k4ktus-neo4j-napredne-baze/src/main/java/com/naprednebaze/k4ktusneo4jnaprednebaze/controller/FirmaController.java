package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Firma;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.FirmaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/firma")
public class FirmaController {

    private final FirmaService firmaService;

    public FirmaController(FirmaService firmaService) {
        this.firmaService = firmaService;
    }

    @GetMapping(
        value = "/getAll"
    )
    public Collection<Firma> getAll() {
        return firmaService.getAll();
    }

    @GetMapping(
            value = "/getFirmaWithKancelarijaId/{idKancelarije}"
    )
    public Collection<Firma> getFirmaWithKancelarijaId(@PathVariable("idKancelarije") Long idKancelarije) {
        return firmaService.getFirmaWithKancelarijaId(idKancelarije);
    }

    @PostMapping(
            value = "/addFirma",
            produces = {"application/json"}
    )
    public HttpStatus addFirma(@RequestParam("datum_od") String datum_od, @RequestParam("datum_do") String datum_do, @RequestParam("broj_kancelarije") Long broj_kancelarije, @RequestBody(required = true) Firma firma) {
        try {
            firmaService.addFirma(datum_od, datum_do, broj_kancelarije, firma);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteFirma",
            produces = {"application/json"}
    )
    public HttpStatus deleteFirma(@RequestBody(required = true) Firma firma) {
        try {
            firmaService.deleteFirma(firma);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateFirma",
            produces = {"application/json"}
    )
    public HttpStatus updateFirma(@RequestBody(required = true) Firma firma) {
        try {
            firmaService.updateFirma(firma);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteAllFirma",
            produces = {"application/json"}
    )
    public HttpStatus deleteAllFirma() {
        try {
            firmaService.deleteAllFirma();
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
