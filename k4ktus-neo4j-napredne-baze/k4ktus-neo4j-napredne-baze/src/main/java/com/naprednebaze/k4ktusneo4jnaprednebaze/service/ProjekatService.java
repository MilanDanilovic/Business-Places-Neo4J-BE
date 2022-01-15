package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.ProjekatDTO;
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

    public void addProjekat(Long pib, String datum_od, String datum_do, ProjekatDTO projekatDTO) {
        projekatRepository.addProjekat(projekatDTO.getNaziv(), projekatDTO.getSifra_projekta());
        radiNaRepository.addRadiNa(pib, projekatDTO.getSifra_projekta(), datum_od, datum_do);
    }

    public void deleteProjekat(ProjekatDTO projekatDTO) {
        projekatRepository.deleteProjekat(projekatDTO.getId());
    }

    public void updateProjekat(Projekat projekat) {
        projekatRepository.updateProjekat(projekat.getId(), projekat.getNaziv(), projekat.getSifra_projekta());
    }

    public void deleteAllProjekat() {
        projekatRepository.deleteAllProjekat();
    }
}
