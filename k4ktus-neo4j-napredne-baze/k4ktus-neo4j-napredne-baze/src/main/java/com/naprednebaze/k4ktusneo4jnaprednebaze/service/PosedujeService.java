package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.PosedujeRepository;
import org.springframework.stereotype.Service;

@Service
public class PosedujeService {

    private PosedujeRepository posedujeRepository;

    public PosedujeService(PosedujeRepository posedujeRepository) {
        this.posedujeRepository = posedujeRepository;
    }
}
