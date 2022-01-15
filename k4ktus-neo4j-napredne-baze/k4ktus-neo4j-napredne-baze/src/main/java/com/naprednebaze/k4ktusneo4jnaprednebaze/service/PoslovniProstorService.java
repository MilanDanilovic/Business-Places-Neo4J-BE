package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.PoslovniProstor;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.PosedujeRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.PoslovniProstorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PoslovniProstorService {

    private PoslovniProstorRepository poslovniProstorRepository;
    private PosedujeRepository posedujeRepository;

    public PoslovniProstorService(PoslovniProstorRepository poslovniProstorRepository, PosedujeRepository posedujeRepository) {
        this.poslovniProstorRepository = poslovniProstorRepository;
        this.posedujeRepository = posedujeRepository;
    }

    public Collection<PoslovniProstor> getAll() {
        return poslovniProstorRepository.getAllPoslovniProstor();
    }

    public void addPoslovniProstor(PoslovniProstor poslovniProstor, Long jmbg, String datum_kupovine) {
        poslovniProstorRepository.addPoslovniProstor(poslovniProstor.getKvadratura(), poslovniProstor.getAdresa());
        posedujeRepository.addPoseduje(datum_kupovine, jmbg, poslovniProstor.getAdresa());
    }

    public void deletePoslovniProstor(PoslovniProstor poslovniProstor) {
        poslovniProstorRepository.deletePoslovniProstor(poslovniProstor.getId());
    }

    public void updatePoslovniProstor(PoslovniProstor poslovniProstor) {
        poslovniProstorRepository.updatePoslovniProstor(poslovniProstor.getId(), poslovniProstor.getKvadratura(), poslovniProstor.getAdresa());
    }

    public void deleteAllPoslovniProstor() {
        poslovniProstorRepository.deleteAllPoslovniProstor();
    }
}
