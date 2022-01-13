package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Rade;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface RadeRepository extends Neo4jRepository<Rade, Long> {

    @Query("MATCH\n" +
            "(a:Firma),\n" +
            "(b:Zaposleni)\n" +
            "WHERE a.pib = $pib AND b.jmbg = $jmbg\n" +
            "CREATE (a)-[r:Rade {datum_od: $datum_od, datum_do: $datum_do, pozicija: $pozicija}]->(b)\n" +
            "RETURN type(r)")
    void addRade(@Param("datum_od") String datum_od, @Param("datum_do") String datum_do, @Param("pozicija") String pozicija, @Param("pib") Long pib, @Param("jmbg") Long jmbg);

    @Query("MATCH (f:Firma)-[r:Rade]->(z:Zaposleni)\n" +
            "WHERE id(f) = $idFirme AND id(z) = $idZaposlenog\n" +
            "SET r={datum_od: $datum_od, datum_do: $datum_do, pozicija: $pozicija}\n" +
            "RETURN r")
    void updateRade(@Param("datum_od") String datum_od, @Param("datum_do") String datum_do, @Param("pozicija") String pozicija, @Param("idFirme") Long idFirme, @Param("idZaposlenog") Long idZaposlenog);
}
