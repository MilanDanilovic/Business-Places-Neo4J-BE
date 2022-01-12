package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Vlasnik;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;

public interface VlasnikRepository extends Neo4jRepository<Vlasnik, Long> {

    @Query("MATCH (n:Vlasnik) RETURN n")
    Collection<Vlasnik> getAllVlasnik();
}
