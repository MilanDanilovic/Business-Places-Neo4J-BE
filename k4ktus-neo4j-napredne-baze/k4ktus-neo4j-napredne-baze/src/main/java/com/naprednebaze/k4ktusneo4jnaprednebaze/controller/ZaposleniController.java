package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.KancelarijaDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.ZaposleniDTO;
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

    @PostMapping(
            value = "/addZaposleni/{datum_od}/{datum_do}/{pozicija}/{pib}",
            produces = {"application/json"}
    )
    public HttpStatus addZaposleni(@PathVariable("datum_od") String datum_od, @PathVariable("datum_do") String datum_do, @PathVariable("pozicija") String pozicija, @PathVariable("pib") Long pib, @RequestBody(required = true) ZaposleniDTO zaposleniDTO) {
        try {
            zaposleniService.addZaposleni(datum_od, datum_do, pozicija, pib, zaposleniDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteZaposleni",
            produces = {"application/json"}
    )
    public HttpStatus deleteZaposleni(@RequestBody(required = true) ZaposleniDTO zaposleniDTO) {
        try {
            zaposleniService.deleteZaposleni(zaposleniDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateZaposleni",
            produces = {"application/json"}
    )
    public HttpStatus updateZaposleni(@RequestBody(required = true) ZaposleniDTO zaposleniDTO) {
        try {
            zaposleniService.updateZaposleni(zaposleniDTO);
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
