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
    private final Firma firma;

    @Property
    private LocalDate datum_od;

    @Property
    private LocalDate datum_do;

    @Property
    private String pozicija;

    public Rade(Firma firma, LocalDate datum_od, LocalDate datum_do, String pozicija) {
        this.id = null;
        this.firma = firma;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
        this.pozicija = pozicija;
    }

    public Rade withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Rade newObject = new Rade(this.firma, this.datum_od, this.datum_do, this.pozicija);
            newObject.id = id;
            return newObject;
        }
    }
}
