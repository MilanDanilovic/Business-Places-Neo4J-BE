package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Firma;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface FirmaRepository extends Neo4jRepository<Firma, Long> {

    @Query("MATCH (n:Firma) return n")
    Collection<Firma> getAllFirma();

    @Query("CREATE(Firma:Firma {naziv: $naziv, godisnja_zarada: $godisnja_zarada, pib: $pib, datum_osnivanja:$datum_osnivanja, idKancelarije:$idKancelarije})")
    void addFirma(@Param("naziv") String naziv, @Param("godisnja_zarada") Double godisnja_zarada, @Param("pib") Long pib, @Param("datum_osnivanja") String datum_osnivanja, @Param("idKancelarije") Long idKancelarije);

    @Query("MATCH (n:Firma)\n" +
            "WHERE id(n) = $id\n" +
            "DETACH DELETE n")
    void deleteFirma(@Param("id") Long id);

    @Query("MATCH (n:Firma)\n" +
            "WHERE id(n) = $id\n" +
            "SET n={naziv: $noviNaziv, godisnja_zarada: $novaGodisnja_zarada, pib: $noviPib, datum_osnivanja: $noviDatum_osnivanja} \n")
    void updateFirma(@Param("id") Long id, @Param("noviNaziv") String noviNaziv, @Param("novaGodisnja_zarada") Double novaGodisnja_zarada, @Param("noviPib") Long noviPib, @Param("noviDatum_osnivanja") String noviDatum_osnivanja);

    @Query("MATCH (n:Firma)\n" +
            "DETACH DELETE n")
    void deleteAllFirma();

    @Query("MATCH (n:Firma)\n" +
            "WHERE n.idKancelarije=$idKancelarije\n" +
            "RETURN n")
    Collection<Firma> getFirmaWithKancelarijaId(@Param("idKancelarije") Long idKancelarije);
}