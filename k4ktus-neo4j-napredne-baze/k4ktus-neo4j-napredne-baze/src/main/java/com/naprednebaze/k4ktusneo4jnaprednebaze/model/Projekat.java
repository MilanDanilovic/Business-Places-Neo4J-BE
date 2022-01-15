package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public class Projekat {
    @Id
    @GeneratedValue
    private Long id;
    private String naziv;
    private Long sifra_projekta;
    private Long idFirme;

    public Projekat(String naziv, Long sifra_projekta, Long idFirme) {
        this.id = null;
        this.naziv = naziv;
        this.sifra_projekta = sifra_projekta;
        this.idFirme = idFirme;
    }

    public Projekat withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Projekat newObject = new Projekat(this.naziv, this.sifra_projekta, this.idFirme);
            newObject.id = id;
            return newObject;
        }
    }

}
