package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Firma;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.FirmaRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.KancelarijaRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.SadrziRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class KancelarijaService {

    private KancelarijaRepository kancelarijaRepository;
    private SadrziRepository sadrziRepository;
    private FirmaRepository firmaRepository;
    private FirmaService firmaService;

    public KancelarijaService(KancelarijaRepository kancelarijaRepository, SadrziRepository sadrziRepository, FirmaRepository firmaRepository, FirmaService firmaService) {
        this.kancelarijaRepository = kancelarijaRepository;
        this.sadrziRepository = sadrziRepository;
        this.firmaRepository = firmaRepository;
        this.firmaService = firmaService;
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
        kancelarijaRepository.addKancelarija(kancelarija.getBroj_kancelarije(), kancelarija.getKvadratura(), kancelarija.getBroj_radnika(), kancelarija.getStatus(), kancelarija.getIdPoslovnogProstora());
        sadrziRepository.addSadrzi(adresa, kancelarija.getBroj_kancelarije());
    }

    public void deleteKancelarija(Kancelarija kancelarija) {
        List<Firma> firmaList = (List<Firma>) firmaRepository.getFirmaWithKancelarijaId(kancelarija.getId());

        for (int i=0; i< firmaList.size(); i++) {
            firmaService.deleteFirma(firmaList.get(i));
        }

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

    public Collection<Kancelarija> getKancelarijaWithPoslovniProstorId(Long idPoslovnogProstora) {
        return kancelarijaRepository.getKancelarijaWithPoslovniProstorId(idPoslovnogProstora);
    }
}
