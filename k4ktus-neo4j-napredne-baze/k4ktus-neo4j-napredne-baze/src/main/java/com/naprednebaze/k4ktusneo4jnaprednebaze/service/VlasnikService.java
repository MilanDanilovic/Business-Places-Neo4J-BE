package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Vlasnik;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.VlasnikRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class VlasnikService {

    private VlasnikRepository vlasnikRepository;

    public VlasnikService(VlasnikRepository vlasnikRepository) {
        this.vlasnikRepository = vlasnikRepository;
    }

    public Collection<Vlasnik> getAll() {
        return vlasnikRepository.getAllVlasnik();
    }

    public void addVlasnik(Vlasnik vlasnik) {
        vlasnikRepository.addVlasnik(vlasnik.getIme(), vlasnik.getPrezime(), vlasnik.getDatum_rodjenja(), vlasnik.getJmbg(), vlasnik.getBroj_telefona());
    }

    public void deleteVlasnik(Vlasnik vlasnik) {
        vlasnikRepository.deleteVlasnik(vlasnik.getId());
    }

    public void updateVlasnik(Vlasnik vlasnik) {
        vlasnikRepository.updateVlasnik(vlasnik.getId(), vlasnik.getIme(), vlasnik.getPrezime(), vlasnik.getDatum_rodjenja(), vlasnik.getJmbg(), vlasnik.getBroj_telefona());
    }

    public void deleteAllVlasnik() {
        vlasnikRepository.deleteAllVlasnik();
    }
}
