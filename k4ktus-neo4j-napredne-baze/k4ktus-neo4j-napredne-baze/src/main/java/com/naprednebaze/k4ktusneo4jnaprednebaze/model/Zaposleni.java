package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;

@Data
@Node("Zaposleni")
public class Zaposleni {
    @Id
    @GeneratedValue
    private Long id;
    private String ime;
    private String prezime;
    private LocalDate datum_rodjenja;
    private String pol;
    private Long jmbg;

    public Zaposleni(String ime, String prezime, LocalDate datum_rodjenja, String pol, Long jmbg) {
        this.id = null;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja;
        this.pol = pol;
        this.jmbg = jmbg;
    }

    public Zaposleni withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Zaposleni newObject = new Zaposleni(this.ime, this.prezime, this.datum_rodjenja, this.pol, this.jmbg);
            newObject.id = id;
            return newObject;
        }
    }
}
