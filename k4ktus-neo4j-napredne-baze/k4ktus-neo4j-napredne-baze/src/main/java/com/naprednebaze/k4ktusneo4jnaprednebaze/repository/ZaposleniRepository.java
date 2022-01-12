package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Zaposleni;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ZaposleniRepository extends Neo4jRepository<Zaposleni, Long> {

    @Query("MATCH (n:Zaposleni) RETURN n")
    Collection<Zaposleni> getAllZaposleni();

    @Query("CREATE(Zaposleni:Zaposleni {ime: $ime, prezime: $prezime, datum_rodjenja: $datum_rodjenja, pol: $pol, jmbg: $jmbg, kartica: $kartica})")
    void addZaposleni(@Param("ime") String ime, @Param("prezime") String prezime, @Param("datum_rodjenja") String datum_rodjenja, @Param("pol") String pol, @Param("jmbg") Long jmbg, @Param("kartica") Long kartica);

    @Query("MATCH (n:Zaposleni)\n" +
            "WHERE id(n) = $id\n" +
            "DETACH DELETE n")
    void deleteZaposleni(@Param("id") Long id);

    @Query("MATCH (n:Zaposleni)\n" +
            "WHERE id(n) = $id\n" +
            "SET n={ime: $ime, prezime: $prezime, datum_rodjenja: $datum_rodjenja, pol: $pol, jmbg: $jmbg, kartica: $kartica} \n")
    void updateZaposleni(@Param("id") Long id, @Param("ime") String ime, @Param("prezime") String prezime, @Param("datum_rodjenja") String datum_rodjenja, @Param("pol") String pol, @Param("jmbg") Long jmbg, @Param("kartica") Long kartica);

    @Query("MATCH (n:Zaposleni)\n" +
            "DETACH DELETE n")
    void deleteAllZaposleni();
}
