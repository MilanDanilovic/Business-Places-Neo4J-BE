package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.PoslovniProstorDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.PoslovniProstor;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.KancelarijaRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.PoslovniProstorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PoslovniProstorService {

    private PoslovniProstorRepository poslovniProstorRepository;
    private KancelarijaRepository kancelarijaRepository;

    public PoslovniProstorService(PoslovniProstorRepository poslovniProstorRepository, KancelarijaRepository kancelarijaRepository) {
        this.poslovniProstorRepository = poslovniProstorRepository;
        this.kancelarijaRepository = kancelarijaRepository;
    }

    public Collection<PoslovniProstor> getAll() {
        return poslovniProstorRepository.getAllPoslovniProstor();
    }

    public void addPoslovniProstor(PoslovniProstorDTO noviPoslovniProstorDTO) {

        /*PoslovniProstor poslovniProstorZaCuvanje = new PoslovniProstor();
        poslovniProstorZaCuvanje.setKvadratura(noviPoslovniProstor.getKvadratura());
        poslovniProstorZaCuvanje.setAdresa(noviPoslovniProstor.getAdresa());*/

        poslovniProstorRepository.addPoslovniProstor(noviPoslovniProstorDTO.getKvadratura(), noviPoslovniProstorDTO.getAdresa());


        /*Kancelarija kancelarijaZaCuvanje = new Kancelarija();
        kancelarijaZaCuvanje.setBroj_kancelarije(novaKancelarija.getBroj_kancelarije());
        kancelarijaZaCuvanje.setKvadratura(novaKancelarija.getKvadratura());
        kancelarijaZaCuvanje.setBroj_radnika(novaKancelarija.getBroj_radnika());
        kancelarijaZaCuvanje.setStatus(novaKancelarija.getStatus());
        kancelarijaZaCuvanje.setFirma(novaKancelarija.getFirma());*/
    }
}
