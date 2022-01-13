package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.ZaposleniDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.RadeRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.ZaposleniRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ZaposleniService {

    private ZaposleniRepository zaposleniRepository;
    private RadeRepository radeRepository;

    public ZaposleniService(ZaposleniRepository zaposleniRepository, RadeRepository radeRepository) {
        this.zaposleniRepository = zaposleniRepository;
        this.radeRepository = radeRepository;
    }

    public Collection<Zaposleni> getAll() {
        return zaposleniRepository.getAllZaposleni();
    }

    public void addZaposleni(String datum_od, String datum_do, String pozicija, Long pib, ZaposleniDTO noviZaposleniDTO) {
        zaposleniRepository.addZaposleni(noviZaposleniDTO.getIme(), noviZaposleniDTO.getPrezime(), noviZaposleniDTO.getDatum_rodjenja(), noviZaposleniDTO.getPol(), noviZaposleniDTO.getJmbg(), noviZaposleniDTO.getKartica());
        radeRepository.addRade(datum_od, datum_do, pozicija, pib, noviZaposleniDTO.getJmbg());
    }

    public void deleteZaposleni(ZaposleniDTO noviZaposleniDTO) {
        zaposleniRepository.deleteZaposleni(noviZaposleniDTO.getId());
    }

    public void updateZaposleni(ZaposleniDTO noviZaposleniDTO) {
        zaposleniRepository.updateZaposleni(noviZaposleniDTO.getId(), noviZaposleniDTO.getIme(), noviZaposleniDTO.getPrezime(), noviZaposleniDTO.getDatum_rodjenja(), noviZaposleniDTO.getPol(), noviZaposleniDTO.getJmbg(), noviZaposleniDTO.getKartica());
    }

    public void deleteAllZaposleni() {
        zaposleniRepository.deleteAllZaposleni();
    }
}
