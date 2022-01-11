package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.VlasnikRepository;
import org.springframework.stereotype.Service;

@Service
public class VlasnikService {

    private VlasnikRepository vlasnikRepository;

    public VlasnikService(VlasnikRepository vlasnikRepository) {
        this.vlasnikRepository = vlasnikRepository;
    }
}
