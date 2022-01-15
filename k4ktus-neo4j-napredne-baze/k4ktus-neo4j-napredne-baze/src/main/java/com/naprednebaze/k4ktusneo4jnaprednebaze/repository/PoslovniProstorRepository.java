package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.PoslovniProstor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PoslovniProstorRepository extends Neo4jRepository<PoslovniProstor, Long> {

    @Query("MATCH (n:PoslovniProstor) RETURN n")
    Collection<PoslovniProstor> getAllPoslovniProstor();

    @Query("CREATE(Zgrada:PoslovniProstor {kvadratura: $kvadratura, adresa: $adresa, idVlasnika:$idVlasnika})")
    void addPoslovniProstor(@Param("kvadratura") Double kvadratura, @Param("adresa") String adresa, @Param("idVlasnika") Long idVlasnika);

    @Query("MATCH (n:PoslovniProstor)\n" +
            "WHERE id(n) = $id\n" +
            "DETACH DELETE n")
    void deletePoslovniProstor(@Param("id") Long id);

    @Query("MATCH (n:PoslovniProstor)\n" +
            "WHERE id(n) = $id\n" +
            "SET n={adresa: $novaAdresa, kvadratura: $novaKvadratura} \n")
    void updatePoslovniProstor(@Param("id") Long id, @Param("novaKvadratura") Double novaKvadratura, @Param("novaAdresa") String novaAdresa);

    @Query("MATCH (n:PoslovniProstor)\n" +
            "DETACH DELETE n")
    void deleteAllPoslovniProstor();

    @Query("MATCH (n:PoslovniProstor)\n" +
            "WHERE n.idVlasnika=$idVlasnika\n" +
            "RETURN n")
    Collection<PoslovniProstor> getPoslovniProstorWithVlasnikId(@Param("ididVlasnika") Long idVlasnika);
}