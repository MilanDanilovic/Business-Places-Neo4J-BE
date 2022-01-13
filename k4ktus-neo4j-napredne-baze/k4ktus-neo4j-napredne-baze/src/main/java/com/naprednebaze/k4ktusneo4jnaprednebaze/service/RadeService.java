package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.RadeDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.RadeRepository;
import org.springframework.stereotype.Service;

@Service
public class RadeService {

    private RadeRepository radeRepository;

    public RadeService(RadeRepository radeRepository) {
        this.radeRepository = radeRepository;
    }

    public void updateRade(Long idFirma, Long idZaposlenog, RadeDTO radeDTO) {
        radeRepository.updateRade(radeDTO.getDatum_od(), radeDTO.getDatum_do(), radeDTO.getPozicija(), idFirma, idZaposlenog);
    }
}
