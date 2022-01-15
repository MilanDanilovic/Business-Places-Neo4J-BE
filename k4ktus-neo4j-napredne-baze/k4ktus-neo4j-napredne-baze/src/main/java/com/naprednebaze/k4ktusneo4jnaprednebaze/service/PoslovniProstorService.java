package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.PoslovniProstor;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.KancelarijaRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.PosedujeRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.PoslovniProstorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PoslovniProstorService {

    private PoslovniProstorRepository poslovniProstorRepository;
    private PosedujeRepository posedujeRepository;
    private KancelarijaService kancelarijaService;
    private KancelarijaRepository kancelarijaRepository;

    public PoslovniProstorService(PoslovniProstorRepository poslovniProstorRepository, PosedujeRepository posedujeRepository, KancelarijaService kancelarijaService, KancelarijaRepository kancelarijaRepository) {
        this.poslovniProstorRepository = poslovniProstorRepository;
        this.posedujeRepository = posedujeRepository;
        this.kancelarijaService = kancelarijaService;
        this.kancelarijaRepository = kancelarijaRepository;
    }

    public Collection<PoslovniProstor> getAll() {
        return poslovniProstorRepository.getAllPoslovniProstor();
    }

    public void addPoslovniProstor(PoslovniProstor poslovniProstor, Long jmbg, String datum_kupovine) {
        poslovniProstorRepository.addPoslovniProstor(poslovniProstor.getKvadratura(), poslovniProstor.getAdresa(), poslovniProstor.getIdVlasnika());
        posedujeRepository.addPoseduje(datum_kupovine, jmbg, poslovniProstor.getAdresa());
    }

    public void deletePoslovniProstor(PoslovniProstor poslovniProstor) {
        List<Kancelarija> kancelarijaList = (List<Kancelarija>) kancelarijaRepository.getKancelarijaWithPoslovniProstorId(poslovniProstor.getId());

        for (int i=0; i<kancelarijaList.size(); i++) {
            kancelarijaService.deleteKancelarija(kancelarijaList.get(i));
        }

        poslovniProstorRepository.deletePoslovniProstor(poslovniProstor.getId());
    }

    public void updatePoslovniProstor(PoslovniProstor poslovniProstor) {
        poslovniProstorRepository.updatePoslovniProstor(poslovniProstor.getId(), poslovniProstor.getKvadratura(), poslovniProstor.getAdresa());
    }

    public void deleteAllPoslovniProstor() {
        poslovniProstorRepository.deleteAllPoslovniProstor();
    }

    public Collection<PoslovniProstor> getPoslovniProstorWithVlasnikId(Long idVlasnika) {
        return poslovniProstorRepository.getPoslovniProstorWithVlasnikId(idVlasnika);
    }
}
