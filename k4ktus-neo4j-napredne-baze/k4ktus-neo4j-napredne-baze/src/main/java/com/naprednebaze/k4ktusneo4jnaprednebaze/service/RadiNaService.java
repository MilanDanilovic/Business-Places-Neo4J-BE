package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.RadiNaDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.RadiNaRepository;
import org.springframework.stereotype.Service;

@Service
public class RadiNaService {

    private RadiNaRepository radiNaRepository;

    public RadiNaService(RadiNaRepository radiNaRepository) {
        this.radiNaRepository = radiNaRepository;
    }

    public void updateRadiNa(Long idFirma, Long idProjekta, RadiNaDTO radiNaDTO) {
        radiNaRepository.updateRadiNa(radiNaDTO.getDatum_od(), radiNaDTO.getDatum_do(), idFirma, idProjekta);
    }
}
