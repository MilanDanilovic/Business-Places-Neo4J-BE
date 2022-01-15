package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.PoslovniProstor;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Vlasnik;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.PoslovniProstorRepository;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.VlasnikRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
public class VlasnikService {

    private VlasnikRepository vlasnikRepository;
    private PoslovniProstorService poslovniProstorService;
    private PoslovniProstorRepository poslovniProstorRepository;

    public VlasnikService(VlasnikRepository vlasnikRepository, PoslovniProstorService poslovniProstorService, PoslovniProstorRepository poslovniProstorRepository) {
        this.vlasnikRepository = vlasnikRepository;
        this.poslovniProstorService = poslovniProstorService;
        this.poslovniProstorRepository = poslovniProstorRepository;
    }

    public Collection<Vlasnik> getAll() {
        return vlasnikRepository.getAllVlasnik();
    }

    public void addVlasnik(Vlasnik vlasnik) {
        vlasnikRepository.addVlasnik(vlasnik.getIme(), vlasnik.getPrezime(), vlasnik.getDatum_rodjenja(), vlasnik.getJmbg(), vlasnik.getBroj_telefona());
    }

    public void deleteVlasnik(Vlasnik vlasnik) {
        List<PoslovniProstor> poslovniProstorList = (List<PoslovniProstor>) poslovniProstorRepository.getPoslovniProstorWithVlasnikId(vlasnik.getId());

        for (int i=0; i<poslovniProstorList.size(); i++) {
            poslovniProstorService.deletePoslovniProstor(poslovniProstorList.get(i));
        }

        vlasnikRepository.deleteVlasnik(vlasnik.getId());
    }

    public void updateVlasnik(Vlasnik vlasnik) {
        vlasnikRepository.updateVlasnik(vlasnik.getId(), vlasnik.getIme(), vlasnik.getPrezime(), vlasnik.getDatum_rodjenja(), vlasnik.getJmbg(), vlasnik.getBroj_telefona());
    }

    public void deleteAllVlasnik() {
        vlasnikRepository.deleteAllVlasnik();
    }
}
