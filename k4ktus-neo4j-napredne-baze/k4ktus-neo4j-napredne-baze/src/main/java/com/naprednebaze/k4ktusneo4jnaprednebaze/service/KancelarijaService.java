package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.KancelarijaDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.KancelarijaRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.SadrziRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KancelarijaService {

    private KancelarijaRepository kancelarijaRepository;
    private SadrziRepository sadrziRepository;

    public KancelarijaService(KancelarijaRepository kancelarijaRepository, SadrziRepository sadrziRepository) {
        this.kancelarijaRepository = kancelarijaRepository;
        this.sadrziRepository = sadrziRepository;
    }

    public Collection<Kancelarija> getAll() {
        return kancelarijaRepository.getAllKancelarija();
    }

    public Collection<Kancelarija> getEmpty() {
        return kancelarijaRepository.getEmptyKancelarija();
    }

    public Collection<Kancelarija> getOccupied() {
        return kancelarijaRepository.getOccupiedKancelarija();
    }

    public void addKancelarija(String adresa, KancelarijaDTO novaKancelarijaDTO) {
        kancelarijaRepository.addKancelarija(novaKancelarijaDTO.getBroj_kancelarije(), novaKancelarijaDTO.getKvadratura(), novaKancelarijaDTO.getBroj_radnika(), novaKancelarijaDTO.getStatus());
        sadrziRepository.addSadrzi(adresa, novaKancelarijaDTO.getBroj_kancelarije());
    }

    public void deleteKancelarija(KancelarijaDTO novaKancelarijaDTO) {
        kancelarijaRepository.deleteKancelarija(novaKancelarijaDTO.getId());
    }

    public void updateKancelarija(KancelarijaDTO novaKancelarijaDTO) {
        kancelarijaRepository.updateKancelarija(novaKancelarijaDTO.getId(), novaKancelarijaDTO.getBroj_kancelarije(), novaKancelarijaDTO.getKvadratura(), novaKancelarijaDTO.getBroj_radnika(), novaKancelarijaDTO.getStatus());
    }

    public void deleteAllKancelarija() {
        kancelarijaRepository.deleteAllKancelarija();
    }
}
