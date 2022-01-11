package com.naprednebaze.k4ktusneo4jnaprednebaze.controller;

import com.naprednebaze.k4ktusneo4jnaprednebaze.service.PosedujeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/poseduje")
public class PosedujeController {

    private final PosedujeService posedujeService;

    public PosedujeController(PosedujeService posedujeService) {
        this.posedujeService = posedujeService;
    }
}
