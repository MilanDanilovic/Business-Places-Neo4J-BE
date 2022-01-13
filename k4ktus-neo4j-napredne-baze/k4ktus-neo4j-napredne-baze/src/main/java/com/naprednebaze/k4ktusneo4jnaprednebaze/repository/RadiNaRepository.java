package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.RadiNa;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface RadiNaRepository extends Neo4jRepository<RadiNa, Long> {

    @Query("MATCH\n" +
            "(a:Firma),\n" +
            "(b:Projekat)\n" +
            "WHERE a.pib = $pib AND b.sifra_projekta = $sifra_projekta\n" +
            "CREATE (a)-[r:RadiNa{datum_od: $datum_od, datum_do: $datum_do}]->(b)\n" +
            "RETURN type(r)")
    void addRadiNa(@Param("pib") Long pib, @Param("sifra_projekta") Long sifra_projekta, @Param("datum_od") String datum_od, @Param("datum_do") String datum_do);

    @Query("MATCH (f:Firma)-[r:RadiNa]->(p:Projekat)\n" +
            "WHERE id(f) = $idFirme AND id(p) = $idProjekta\n" +
            "SET r={datum_od: $datum_od, datum_do: $datum_do}\n" +
            "RETURN r")
    void updateRadiNa(@Param("datum_od") String datum_od, @Param("datum_do") String datum_do, @Param("idFirme") Long idFirme, @Param("idProjekta") Long idProjekta);
}
