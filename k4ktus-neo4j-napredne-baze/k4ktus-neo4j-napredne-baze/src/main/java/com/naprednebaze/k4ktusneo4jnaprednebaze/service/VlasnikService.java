package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Vlasnik;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.VlasnikRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VlasnikService {

    private VlasnikRepository vlasnikRepository;

    public VlasnikService(VlasnikRepository vlasnikRepository) {
        this.vlasnikRepository = vlasnikRepository;
    }

    public Collection<Vlasnik> getAll() {
        return vlasnikRepository.getAllVlasnik();
    }
}
