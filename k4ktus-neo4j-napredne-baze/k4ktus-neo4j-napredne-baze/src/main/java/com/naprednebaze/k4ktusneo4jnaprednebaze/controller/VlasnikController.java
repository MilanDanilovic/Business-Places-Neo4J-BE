package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Firma;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Vlasnik;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.VlasnikService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/vlasnik")
public class VlasnikController {

    private final VlasnikService vlasnikService;

    public VlasnikController(VlasnikService vlasnikService) {
        this.vlasnikService = vlasnikService;
    }

    @GetMapping(
            value = "/getAll"
    )
    public Collection<Vlasnik> getAll() {
        return vlasnikService.getAll();
    }

    @PostMapping(
            value = "/addVlasnik",
            produces = {"application/json"}
    )
    public HttpStatus addVlasnik(@RequestBody(required = true) Vlasnik vlasnik) {
        try {
            vlasnikService.addVlasnik(vlasnik);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteVlasnik",
            produces = {"application/json"}
    )
    public HttpStatus deleteVlasnik(@RequestBody(required = true) Vlasnik vlasnik) {
        try {
            vlasnikService.deleteVlasnik(vlasnik);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateVlasnik",
            produces = {"application/json"}
    )
    public HttpStatus updateVlasnik(@RequestBody(required = true) Vlasnik vlasnik) {
        try {
            vlasnikService.updateVlasnik(vlasnik);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteAllVlasnik",
            produces = {"application/json"}
    )
    public HttpStatus deleteAllVlasnik() {
        try {
            vlasnikService.deleteAllVlasnik();
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

}
