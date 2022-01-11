package com.naprednebaze.k4ktusneo4jnaprednebaze.service;

import com.naprednebaze.k4ktusneo4jnaprednebaze.repository.IznajmljujeRepository;
import org.springframework.stereotype.Service;

@Service
public class IznajmljujeService {

    private IznajmljujeRepository iznajmljujeRepository;

    public IznajmljujeService(IznajmljujeRepository iznajmljujeRepository) {
        this.iznajmljujeRepository = iznajmljujeRepository;
    }
}
