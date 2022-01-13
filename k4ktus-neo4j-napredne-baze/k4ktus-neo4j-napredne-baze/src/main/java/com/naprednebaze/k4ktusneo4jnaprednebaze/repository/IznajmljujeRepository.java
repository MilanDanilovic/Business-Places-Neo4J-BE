package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Iznajmljuje;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface IznajmljujeRepository extends Neo4jRepository<Iznajmljuje, Long> {

    @Query("MATCH\n" +
            "(a:Kancelarija),\n" +
            "(b:Firma)\n" +
            "WHERE a.broj_kancelarije = $broj_kancelarije AND b.pib = $pib\n" +
            "CREATE (a)-[r:Iznajmljuje {datum_od: $datum_od, datum_do: $datum_do}]->(b)\n" +
            "RETURN type(r)")
    void addIznajmljuje(@Param("datum_od") String datum_od, @Param("datum_do") String datum_do, @Param("broj_kancelarije") Long broj_kancelarije, @Param("pib") Long pib);

    @Query("MATCH (k:Kancelarija)-[i:Iznajmljuje]->(f:Firma)\n" +
            "WHERE id(k) = $idKancelarije AND id(f) = $idFirme\n" +
            "SET i={datum_od: $datum_od, datum_do: $datum_do}\n" +
            "RETURN i")
    void updateIznajmljuje(@Param("datum_od") String datum_od, @Param("datum_do") String datum_do, @Param("idKancelarije") Long idKancelarije, @Param("idFirme") Long idFirme);
}