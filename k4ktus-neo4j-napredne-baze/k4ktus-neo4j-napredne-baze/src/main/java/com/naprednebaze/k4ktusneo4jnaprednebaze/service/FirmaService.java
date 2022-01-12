package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.FirmaDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Firma;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.FirmaRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.IznajmljujeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FirmaService {

    private FirmaRepository firmaRepository;
    private IznajmljujeRepository iznajmljujeRepository;

    public FirmaService(FirmaRepository firmaRepository, IznajmljujeRepository iznajmljujeRepository) {
        this.firmaRepository = firmaRepository;
        this.iznajmljujeRepository = iznajmljujeRepository;
    }

    public Collection<Firma>getAll() {
        return firmaRepository.getAllFirma();
    }

    public void addFirma(String datum_od, String datum_do, Long broj_kancelarije, FirmaDTO noviFirmaDTO) {
        firmaRepository.addFirma(noviFirmaDTO.getNaziv(), noviFirmaDTO.getGodisnja_zarada(), noviFirmaDTO.getPib(), noviFirmaDTO.getDatum_osnivanja());
        iznajmljujeRepository.addIznajmljuje(datum_od, datum_do, broj_kancelarije, noviFirmaDTO.getPib());
    }

    public void deleteFirma(FirmaDTO noviFirmaDTO) {
        firmaRepository.deleteFirma(noviFirmaDTO.getId());
    }

    public void updateFirma(FirmaDTO noviFirmaDTO) {
        firmaRepository.updateFirma(noviFirmaDTO.getId(), noviFirmaDTO.getNaziv(), noviFirmaDTO.getGodisnja_zarada(), noviFirmaDTO.getPib(), noviFirmaDTO.getDatum_osnivanja());
    }

    public void deleteAllFirma() {
        firmaRepository.deleteAllFirma();
    }
}
