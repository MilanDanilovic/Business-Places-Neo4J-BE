package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;

public interface KancelarijaRepository extends Neo4jRepository<Kancelarija, Long> {

    @Query("MATCH (n:Kancelarija) RETURN n")
    Collection<Kancelarija> getAllKancelarija();

    @Query("MATCH (n:Kancelarija {status: 'false'}) RETURN n.broj_kancelarije ")
    Collection<Kancelarija> getEmptyKancelarija();

    @Query("MATCH (n:Kancelarija {status: 'true'}) RETURN n.broj_kancelarije ")
    Collection<Kancelarija> getOccupiedKancelarija();
}
