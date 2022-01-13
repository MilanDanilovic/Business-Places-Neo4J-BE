package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.PosedujeDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.service.PosedujeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/neo4j/poseduje")
public class PosedujeController {

    private final PosedujeService posedujeService;

    public PosedujeController(PosedujeService posedujeService) {
        this.posedujeService = posedujeService;
    }

    @PutMapping(
            value = "/updatePoseduje/{idVlasnika}/{idPoslovnogProstora}",
            produces = {"application/json"}
    )
    public HttpStatus updatePoseduje(@PathVariable("idVlasnika") Long idVlasnika, @PathVariable("idPoslovnogProstora") Long idPoslovnogProstora, @RequestBody(required = true) PosedujeDTO posedujeDTO) {
        try {
            posedujeService.updatePoseduje(idVlasnika, idPoslovnogProstora, posedujeDTO);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
}
