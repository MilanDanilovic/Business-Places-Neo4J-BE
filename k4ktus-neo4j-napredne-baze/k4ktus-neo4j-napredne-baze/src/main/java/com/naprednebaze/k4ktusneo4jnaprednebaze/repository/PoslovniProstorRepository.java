package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.PoslovniProstor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PoslovniProstorRepository extends Neo4jRepository<PoslovniProstor, Long> {

    @Query("MATCH (n:PoslovniProstor) RETURN n")
    Collection<PoslovniProstor> getAllPoslovniProstor();

    @Query("CREATE(Zgrada:PoslovniProstor {kvadratura: $kvadratura, adresa: $adresa})")
    void addPoslovniProstor(@Param("kvadratura") Double kvadratura, @Param("adresa") String adresa);
}
