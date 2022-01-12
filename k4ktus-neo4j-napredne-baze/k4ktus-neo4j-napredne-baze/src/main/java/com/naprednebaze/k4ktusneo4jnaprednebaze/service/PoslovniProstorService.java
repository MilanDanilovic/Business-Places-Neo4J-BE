package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.PoslovniProstorDTO;
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

    public void addPoslovniProstor(PoslovniProstorDTO noviPoslovniProstorDTO, Long jmbg, String datum_kupovine) {
        poslovniProstorRepository.addPoslovniProstor(noviPoslovniProstorDTO.getKvadratura(), noviPoslovniProstorDTO.getAdresa());
        posedujeRepository.addPoseduje(datum_kupovine, jmbg, noviPoslovniProstorDTO.getAdresa());
    }

    public void deletePoslovniProstor(PoslovniProstorDTO noviPoslovniProstorDTO) {
        poslovniProstorRepository.deletePoslovniProstor(noviPoslovniProstorDTO.getId());
    }

    public void updatePoslovniProstor(PoslovniProstorDTO noviPoslovniProstorDTO) {
        poslovniProstorRepository.updatePoslovniProstor(noviPoslovniProstorDTO.getId(), noviPoslovniProstorDTO.getKvadratura(), noviPoslovniProstorDTO.getAdresa());
    }

    public void deleteAllPoslovniProstor() {
        poslovniProstorRepository.deleteAllPoslovniProstor();
    }
}
