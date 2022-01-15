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

    public void addZaposleni(String datum_od, String datum_do, String pozicija, Long pib, Zaposleni zaposleni) {
        zaposleniRepository.addZaposleni(zaposleni.getIme(), zaposleni.getPrezime(), zaposleni.getDatum_rodjenja(), zaposleni.getPol(), zaposleni.getJmbg(), zaposleni.getKartica());
        radeRepository.addRade(datum_od, datum_do, pozicija, pib, zaposleni.getJmbg());
    }

    public void deleteZaposleni(Zaposleni zaposleni) {
        zaposleniRepository.deleteZaposleni(zaposleni.getId());
    }

    public void updateZaposleni(Zaposleni zaposleni) {
        zaposleniRepository.updateZaposleni(zaposleni.getId(), zaposleni.getIme(), zaposleni.getPrezime(), zaposleni.getDatum_rodjenja(), zaposleni.getPol(), zaposleni.getJmbg(), zaposleni.getKartica());
    }

    public void deleteAllZaposleni() {
        zaposleniRepository.deleteAllZaposleni();
    }
}
