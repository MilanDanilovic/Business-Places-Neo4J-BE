package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.ZaposleniService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/zaposleni")
public class ZaposleniController {

    private final ZaposleniService zaposleniService;

    public ZaposleniController(ZaposleniService zaposleniService) {
        this.zaposleniService = zaposleniService;
    }

    @GetMapping(
            value = "/getAll"
    )
    public Collection<Zaposleni> getAll() {
        return zaposleniService.getAll();
    }

    @GetMapping(
            value = "/getZaposleniWithFirmaId/{idFirme}"
    )
    public Collection<Zaposleni> getZaposleniWithFirmaId(@PathVariable("idFirme") Long idFirme) {
        return zaposleniService.getZaposleniWithFirmaId(idFirme);
    }

    @PostMapping(
            value = "/addZaposleni",
            produces = {"application/json"}
    )
    public HttpStatus addZaposleni(@RequestParam("datum_od") String datum_od, @RequestParam("datum_do") String datum_do, @RequestParam("pozicija") String pozicija, @RequestParam("pib") Long pib, @RequestBody(required = true) Zaposleni zaposleni) {
        try {
            zaposleniService.addZaposleni(datum_od, datum_do, pozicija, pib, zaposleni);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteZaposleni",
            produces = {"application/json"}
    )
    public HttpStatus deleteZaposleni(@RequestBody(required = true) Zaposleni zaposleni) {
        try {
            zaposleniService.deleteZaposleni(zaposleni);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateZaposleni",
            produces = {"application/json"}
    )
    public HttpStatus updateZaposleni(@RequestBody(required = true) Zaposleni zaposleni) {
        try {
            zaposleniService.updateZaposleni(zaposleni);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteAllZaposleni",
            produces = {"application/json"}
    )
    public HttpStatus deleteAllZaposleni() {
        try {
            zaposleniService.deleteAllZaposleni();
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
