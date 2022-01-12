package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Poseduje;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface PosedujeRepository extends Neo4jRepository<Poseduje, Long> {

    @Query("MATCH\n" +
            "(a:Vlasnik),\n" +
            "(b:PoslovniProstor)\n" +
            "WHERE a.jmbg = $jmbg AND b.adresa = $adresa\n" +
            "CREATE (a)-[r:Poseduje {datum_kupovine: $datum_kupovine}]->(b)\n" +
            "RETURN type(r)")
    void addPoseduje(@Param("datum_kupovine") String datum_kupovine, @Param("jmbg") Long jmbg, @Param("adresa") String adresa);
}
