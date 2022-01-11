package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Firma;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;

public interface FirmaRepository extends Neo4jRepository<Firma, Long> {

    @Query("MATCH (n:Firma) RETURN n")
    Collection<Firma> getAllFirma();
}
