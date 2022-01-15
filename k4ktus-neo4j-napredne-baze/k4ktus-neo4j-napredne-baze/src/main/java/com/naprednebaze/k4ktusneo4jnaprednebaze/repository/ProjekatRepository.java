package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Projekat;
import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProjekatRepository extends Neo4jRepository<Projekat, Long> {

    @Query("MATCH (n:Projekat) return n")
    Collection<Projekat> getAllProjekat();

    @Query("CREATE(Projekat:Projekat {naziv: $naziv, sifra_projekta: $sifra_projekta, idFirme:$idFirme})")
    void addProjekat(@Param("naziv") String naziv, @Param("sifra_projekta") Long sifra_projekta, @Param("idFirme") Long idFirme);

    @Query("MATCH (n:Projekat)\n" +
            "WHERE id(n) = $id\n" +
            "DETACH DELETE n")
    void deleteProjekat(@Param("id") Long id);

    @Query("MATCH (n:Projekat)\n" +
            "WHERE id(n) = $id\n" +
            "SET n={naziv: $noviNaziv, sifra_projekta: $novaSifra_projekta} \n")
    void updateProjekat(@Param("id") Long id, @Param("noviNaziv") String noviNaziv, @Param("novaSifra_projekta") Long novaSifra_projekta);

    @Query("MATCH (n:Projekat)\n" +
            "DETACH DELETE n")
    void deleteAllProjekat();

    @Query("MATCH (n:Projekat)\n" +
            "WHERE n.idFirme=$idFirme\n" +
            "RETURN n")
    Collection<Projekat> getProjekatWithFirmaId(@Param("idFirme") Long idFirme);
}
