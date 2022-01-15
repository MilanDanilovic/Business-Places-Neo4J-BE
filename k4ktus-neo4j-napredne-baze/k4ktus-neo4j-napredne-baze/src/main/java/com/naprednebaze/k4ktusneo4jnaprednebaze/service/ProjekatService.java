package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Projekat;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.ProjekatRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.RadiNaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProjekatService {

    private ProjekatRepository projekatRepository;
    private RadiNaRepository radiNaRepository;

    public ProjekatService(ProjekatRepository projekatRepository, RadiNaRepository radiNaRepository) {
        this.projekatRepository = projekatRepository;
        this.radiNaRepository = radiNaRepository;
    }

    public Collection<Projekat> getAll() {
        return projekatRepository.getAllProjekat();
    }

    public void addProjekat(Long pib, String datum_od, String datum_do, Projekat projekat) {
        projekatRepository.addProjekat(projekat.getNaziv(), projekat.getSifra_projekta(), projekat.getIdFirme());
        radiNaRepository.addRadiNa(pib, projekat.getSifra_projekta(), datum_od, datum_do);
    }

    public void deleteProjekat(Projekat projekat) {
        projekatRepository.deleteProjekat(projekat.getId());
    }

    public void updateProjekat(Projekat projekat) {
        projekatRepository.updateProjekat(projekat.getId(), projekat.getNaziv(), projekat.getSifra_projekta());
    }

    public void deleteAllProjekat() {
        projekatRepository.deleteAllProjekat();
    }

    public Collection<Projekat> getProjekatWithFirmaId(Long idFirme) {
        return projekatRepository.getProjekatWithFirmaId(idFirme);
    }
}
