package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.KancelarijaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/kancelarija")
public class KancelarijaController {

    private final KancelarijaService kancelarijaService;

    public KancelarijaController(KancelarijaService kancelarijaService) {
        this.kancelarijaService = kancelarijaService;
    }

    @GetMapping(
            value = "/getAll"
    )
    public Collection<Kancelarija> getAll() {
        return kancelarijaService.getAll();
    }

    @GetMapping(
            value = "/getKancelarijaWithPoslovniProstorId/{idPoslovnogProstora}"
    )
    public Collection<Kancelarija> getKancelarijaWithPoslovniProstorId(@PathVariable("idPoslovnogProstora") Long idPoslovnogProstora) {
        return kancelarijaService.getKancelarijaWithPoslovniProstorId(idPoslovnogProstora);
    }

    @GetMapping(
            value = "/getEmpty"
    )
    public Collection<Kancelarija> getEmpty() {
        return kancelarijaService.getEmpty();
    }

    @GetMapping(
            value = "/getOccupied"
    )
    public Collection<Kancelarija> getOccupied() {
        return kancelarijaService.getOccupied();
    }

    @PostMapping(
            value = "/addKancelarija",
            produces = {"application/json"}
    )
    public HttpStatus addKancelarija(@RequestParam("adresa") String adresa, @RequestBody(required = true) Kancelarija kancelarija) {
        try {
            kancelarijaService.addKancelarija(adresa, kancelarija);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteKancelarija",
            produces = {"application/json"}
    )
    public HttpStatus deleteKancelarija(@RequestBody(required = true) Kancelarija kancelarija) {
        try {
            kancelarijaService.deleteKancelarija(kancelarija);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateKancelarija",
            produces = {"application/json"}
    )
    public HttpStatus updateKancelarija(@RequestBody(required = true) Kancelarija kancelarija) {
        try {
            kancelarijaService.updateKancelarija(kancelarija);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteAllKancelarija",
            produces = {"application/json"}
    )
    public HttpStatus deleteAllKancelarija() {
        try {
            kancelarijaService.deleteAllKancelarija();
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateStatusKancelarija/{id}/{status}",
            produces = {"application/json"}
    )
    public HttpStatus updateStatusKancelarija(@PathVariable("id") Long id, @PathVariable("status") Boolean status) {
        try {
            kancelarijaService.updateStatusKancelarija(id, status);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
