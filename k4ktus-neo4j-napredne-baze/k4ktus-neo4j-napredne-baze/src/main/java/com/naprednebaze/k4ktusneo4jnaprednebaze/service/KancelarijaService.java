package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

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

    public void addKancelarija(String adresa, Kancelarija kancelarija) {
        kancelarijaRepository.addKancelarija(kancelarija.getBroj_kancelarije(), kancelarija.getKvadratura(), kancelarija.getBroj_radnika(), kancelarija.getStatus());
        sadrziRepository.addSadrzi(adresa, kancelarija.getBroj_kancelarije());
    }

    public void deleteKancelarija(Kancelarija kancelarija) {
        kancelarijaRepository.deleteKancelarija(kancelarija.getId());
    }

    public void updateKancelarija(Kancelarija kancelarija) {
        kancelarijaRepository.updateKancelarija(kancelarija.getId(), kancelarija.getBroj_kancelarije(), kancelarija.getKvadratura(), kancelarija.getBroj_radnika(), kancelarija.getStatus());
    }

    public void deleteAllKancelarija() {
        kancelarijaRepository.deleteAllKancelarija();
    }

    public void updateStatusKancelarija(Long id, Boolean status) {
        kancelarijaRepository.updateStatusKancelarija(id, status);
    }
}
