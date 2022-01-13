package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Kancelarija;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface KancelarijaRepository extends Neo4jRepository<Kancelarija, Long> {

    @Query("MATCH (n:Kancelarija) RETURN n")
    Collection<Kancelarija> getAllKancelarija();

    @Query("MATCH (n:Kancelarija {status: 'false'}) RETURN n.broj_kancelarije ")
    Collection<Kancelarija> getEmptyKancelarija();

    @Query("MATCH (n:Kancelarija {status: 'true'}) RETURN n.broj_kancelarije ")
    Collection<Kancelarija> getOccupiedKancelarija();

    @Query("CREATE(Kancelarija:Kancelarija {broj_kancelarije: $broj_kancelarije, kvadratura: $kvadratura, broj_radnika: $broj_radnika, status: $status})")
    void addKancelarija(@Param("broj_kancelarije") Long broj_kancelarije, @Param("kvadratura") Double kvadratura, @Param("broj_radnika") Long broj_radnika, @Param("status") String status);

    @Query("MATCH (n:Kancelarija)\n" +
            "WHERE id(n) = $id\n" +
            "DETACH DELETE n")
    void deleteKancelarija(@Param("id") Long id);

    @Query("MATCH (n:Kancelarija)\n" +
            "WHERE id(n) = $id\n" +
            "SET n={broj_kancelarije: $noviBroj_kancelarije, kvadratura: $novaKvadratura, broj_radnika: $noviBroj_radnika, status: $noviStatus} \n")
    void updateKancelarija(@Param("id") Long id, @Param("noviBroj_kancelarije") Long noviBroj_kancelarije, @Param("novaKvadratura") Double novaKvadratura, @Param("noviBroj_radnika") Long noviBroj_radnika, @Param("noviStatus") String noviStatus);

    @Query("MATCH (n:Kancelarija)\n" +
            "DETACH DELETE n")
    void deleteAllKancelarija();

    @Query("MATCH (n:Kancelarija)\n" +
            "WHERE id(n) = $id\n" +
            "SET n={ status: $noviStatus} \n")
    void updateStatusKancelarija(@Param("id") Long id, @Param("noviStatus") String noviStatus);
}
