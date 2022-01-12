package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;

public interface ZaposleniRepository extends Neo4jRepository<Zaposleni, Long> {

    @Query("MATCH (n:Zaposleni) RETURN n")
    Collection<Zaposleni> getAllZaposleni();
}
