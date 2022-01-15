package com.naprednebaze.k4ktusneo4jnaprednebaze.repository;

import com.naprednebaze.k4ktusneo4jnaprednebaze.model.Vlasnik;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import java.util.Collection;

public interface VlasnikRepository extends Neo4jRepository<Vlasnik, Long> {

    @Query("MATCH (n:Vlasnik) RETURN n")
    Collection<Vlasnik> getAllVlasnik();

    @Query("CREATE(Vlasnik:Vlasnik {ime: $ime, prezime: $prezime, datum_rodjenja: $datum_rodjenja, jmbg: $jmbg, broj_telefona:$broj_telefona})")
    void addVlasnik(@Param("ime") String ime, @Param("prezime") String prezime, @Param("datum_rodjenja") String datum_rodjenja, @Param("jmbg") Long jmbg, @Param("broj_telefona") String broj_telefona);

    @Query("MATCH (n:Vlasnik)\n" +
            "WHERE id(n) = $id\n" +
            "DETACH DELETE n")
    void deleteVlasnik(@Param("id") Long id);

    @Query("MATCH (n:Vlasnik)\n" +
            "WHERE id(n) = $id\n" +
            "SET n={ime: $ime, prezime: $prezime, datum_rodjenja: $datum_rodjenja, jmbg: $jmbg, broj_telefona:$broj_telefona} \n")
    void updateVlasnik(@Param("id") Long id, @Param("ime") String ime, @Param("prezime") String prezime, @Param("datum_rodjenja") String datum_rodjenja, @Param("jmbg") Long jmbg, @Param("broj_telefona") String broj_telefona);

    @Query("MATCH (n:Vlasnik)\n" +
            "DETACH DELETE n")
    void deleteAllVlasnik();

}
