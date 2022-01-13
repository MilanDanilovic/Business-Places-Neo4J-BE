package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.IznajmljujeDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.IznajmljujeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/neo4j/iznajmljuje")
public class IznajmljujeController {

    private final IznajmljujeService iznajmljujeService;

    public IznajmljujeController(IznajmljujeService iznajmljujeService) {
        this.iznajmljujeService = iznajmljujeService;
    }

    @PutMapping(
            value = "/updateIznajmljuje/{idKancelarije}/{idFirme}",
            produces = {"application/json"}
    )
    public HttpStatus updateIznajmljuje(@PathVariable("idKancelarije") Long idKancelarije, @PathVariable("idFirme") Long idFirme, @RequestBody(required = true) IznajmljujeDTO iznajmljujeDTO) {
        try {
            iznajmljujeService.updateIznajmljuje(idKancelarije, idFirme, iznajmljujeDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
