package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.ProjekatDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Projekat;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.ProjekatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/projekat")
public class ProjekatController {

    private final ProjekatService projekatService;

    public ProjekatController(ProjekatService projekatService) {
        this.projekatService = projekatService;
    }

    @GetMapping(
            value = "/getAll",
            produces = {"application/json"}
    )
    public Collection<Projekat> getAll() {
        return projekatService.getAll();
    }

    @PostMapping(
            value = "/addProjekat/{pib}/{datum_od}/{datum_do}",
            produces = {"application/json"}
    )
    public HttpStatus addProjekat(@PathVariable("pib") Long pib, @PathVariable("datum_od") String datum_od, @PathVariable("datum_do") String datum_do, @RequestBody(required = true) ProjekatDTO projekatDTO) {
        try {
            projekatService.addProjekat(pib, datum_od, datum_do, projekatDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteProjekat",
            produces = {"application/json"}
    )
    public HttpStatus deleteProjekat(@RequestBody(required = true) ProjekatDTO projekatDTO) {
        try {
            projekatService.deleteProjekat(projekatDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateProjekat",
            produces = {"application/json"}
    )
    public HttpStatus updateProjekat(@RequestBody(required = true) ProjekatDTO projekatDTO) {
        try {
            projekatService.updateProjekat(projekatDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteAllProjekat",
            produces = {"application/json"}
    )
    public HttpStatus deleteAllProjekat() {
        try {
            projekatService.deleteAllProjekat();
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
