package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.RadeDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.RadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/neo4j/rade")
public class RadeController {

    private final RadeService radeService;

    public RadeController(RadeService radeService) {
        this.radeService = radeService;
    }

    @PutMapping(
            value = "/updateRade/{idFirme}/{idZaposlenog}",
            produces = {"application/json"}
    )
    public HttpStatus updateRade(@PathVariable("idFirme") Long idFirme, @PathVariable("idZaposlenog") Long idZaposlenog, @RequestBody(required = true) RadeDTO radeDTO) {
        try {
            radeService.updateRade(idFirme, idZaposlenog, radeDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
