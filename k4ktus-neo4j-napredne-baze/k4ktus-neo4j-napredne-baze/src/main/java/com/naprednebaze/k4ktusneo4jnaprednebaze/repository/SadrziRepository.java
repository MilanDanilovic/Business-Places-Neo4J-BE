package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Sadrzi;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface SadrziRepository extends Neo4jRepository<Sadrzi, Long> {

    @Query("MATCH\n" +
            "(a:Kancelarija),\n" +
            "(b:PoslovniProstor)\n" +
            "WHERE a.broj_kancelarije = $broj_kancelarije AND b.adresa = $adresa\n" +
            "CREATE (b)-[r:Sadrzi]->(a)\n" +
            "RETURN type(r)")
    void addSadrzi(@Param("adresa") String adresa, @Param("broj_kancelarije") Long broj_kancelarije);
}