package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.FirmaDTO;
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
        value = "/getAll",
        produces = {"application/json"}
    )
    public Collection<Firma> getAll() {
        return firmaService.getAll();
    }

    @PostMapping(
            value = "/addFirma/{datum_od}/{datum_do}/{broj_kancelarije}",
            produces = {"application/json"}
    )
    public HttpStatus addFirma(@PathVariable("datum_od") String datum_od, @PathVariable("datum_do") String datum_do, @PathVariable("broj_kancelarije") Long broj_kancelarije, @RequestBody(required = true) FirmaDTO firmaDTO) {
        try {
            firmaService.addFirma(datum_od, datum_do, broj_kancelarije, firmaDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteFirma",
            produces = {"application/json"}
    )
    public HttpStatus deleteFirma(@RequestBody(required = true) FirmaDTO firmaDTO) {
        try {
            firmaService.deleteFirma(firmaDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateFirma",
            produces = {"application/json"}
    )
    public HttpStatus updateFirma(@RequestBody(required = true) FirmaDTO firmaDTO) {
        try {
            firmaService.updateFirma(firmaDTO);
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
