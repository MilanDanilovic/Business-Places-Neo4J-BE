package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;

@Data
@RelationshipProperties
public class Rade {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Zaposleni zaposleni;

    @Property
    private String datum_od;

    @Property
    private String datum_do;

    @Property
    private String pozicija;

    public Rade(Zaposleni zaposleni, String datum_od, String datum_do, String pozicija) {
        this.id = null;
        this.zaposleni = zaposleni;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
        this.pozicija = pozicija;
    }

    public Rade withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Rade newObject = new Rade(this.zaposleni, this.datum_od, this.datum_do, this.pozicija);
            newObject.id = id;
            return newObject;
        }
    }
}
