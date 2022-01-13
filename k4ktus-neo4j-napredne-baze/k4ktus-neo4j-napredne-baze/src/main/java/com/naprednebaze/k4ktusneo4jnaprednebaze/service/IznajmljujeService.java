package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.dto.IznajmljujeDTO;
import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.IznajmljujeRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class IznajmljujeService {

    private IznajmljujeRepository iznajmljujeRepository;

    public IznajmljujeService(IznajmljujeRepository iznajmljujeRepository) {
        this.iznajmljujeRepository = iznajmljujeRepository;
    }

    public void updateIznajmljuje(Long idKancelarije, Long idFirme, IznajmljujeDTO iznajmljujeDTO) {
        iznajmljujeRepository.updateIznajmljuje(iznajmljujeDTO.getDatum_od(), iznajmljujeDTO.getDatum_do(), idKancelarije, idFirme);
    }
}
