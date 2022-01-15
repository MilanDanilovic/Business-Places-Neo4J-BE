package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Firma;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Projekat;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.FirmaRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.IznajmljujeRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.ProjekatRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.ZaposleniRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FirmaService {

    private FirmaRepository firmaRepository;
    private IznajmljujeRepository iznajmljujeRepository;
    private ZaposleniRepository zaposleniRepository;
    private ProjekatRepository projekatRepository;

    public FirmaService(FirmaRepository firmaRepository, IznajmljujeRepository iznajmljujeRepository, ZaposleniRepository zaposleniRepository, ProjekatRepository projekatRepository) {
        this.firmaRepository = firmaRepository;
        this.iznajmljujeRepository = iznajmljujeRepository;
        this.zaposleniRepository = zaposleniRepository;
        this.projekatRepository = projekatRepository;
    }

    public Collection<Firma>getAll() {
        return firmaRepository.getAllFirma();
    }

    public void addFirma(String datum_od, String datum_do, Long broj_kancelarije, Firma firma) {
        firmaRepository.addFirma(firma.getNaziv(), firma.getGodisnja_zarada(), firma.getPib(), firma.getDatum_osnivanja());
        iznajmljujeRepository.addIznajmljuje(datum_od, datum_do, broj_kancelarije, firma.getPib());
    }

    public void deleteFirma(Firma firma) {
        Long idFirme = firma.getId();
        List<Zaposleni> zaposleniList = (List<Zaposleni>) zaposleniRepository.getZaposleniWithFirmaId(idFirme);
        List<Projekat> projekatList = (List<Projekat>) projekatRepository.getProjekatWithFirmaId(idFirme);

        for (int i=0; i<zaposleniList.size(); i++){
            zaposleniRepository.deleteZaposleni(zaposleniList.get(i).getId());
        }
        for (int j=0; j<projekatList.size(); j++) {
            projekatRepository.deleteProjekat(projekatList.get(j).getId());
        }

        firmaRepository.deleteFirma(firma.getId());
    }

    public void updateFirma(Firma firma) {
        firmaRepository.updateFirma(firma.getId(), firma.getNaziv(), firma.getGodisnja_zarada(), firma.getPib(), firma.getDatum_osnivanja());
    }

    public void deleteAllFirma() {
        firmaRepository.deleteAllFirma();
    }
}
