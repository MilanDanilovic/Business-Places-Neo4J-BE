package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.RadiNaDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.RadiNaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/neo4j/radina")
public class RadiNaController {

    private final RadiNaService radiNaService;

    public RadiNaController(RadiNaService radiNaService) {
        this.radiNaService = radiNaService;
    }

    @PutMapping(
            value = "/updateRadiNa/{idFirme}/{idProjekta}",
            produces = {"application/json"}
    )
    public HttpStatus updateRadiNa(@PathVariable("idFirme") Long idFirme, @PathVariable("idProjekta") Long idProjekta, @RequestBody(required = true) RadiNaDTO radiNaDTO) {
        try {
            radiNaService.updateRadiNa(idFirme, idProjekta, radiNaDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
