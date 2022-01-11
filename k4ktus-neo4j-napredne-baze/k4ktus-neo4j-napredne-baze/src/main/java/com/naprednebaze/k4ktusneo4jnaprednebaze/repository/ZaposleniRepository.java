package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ZaposleniRepository extends Neo4jRepository<Zaposleni, Long> {
    //todo
}
