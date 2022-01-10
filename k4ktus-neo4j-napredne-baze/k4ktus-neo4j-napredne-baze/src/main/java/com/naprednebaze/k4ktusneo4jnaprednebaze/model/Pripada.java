package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;

@Data
@RelationshipProperties
public class Pripada {

    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Vlasnik vlasnik;

    @Property
    private LocalDate datum_kupovine;

    public Pripada(Vlasnik vlasnik, LocalDate datum_kupovine) {
        this.id = null;
        this.datum_kupovine = datum_kupovine;
        this.vlasnik = vlasnik;
    }

    public Pripada withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Pripada newObject = new Pripada(this.vlasnik, this.datum_kupovine);
            newObject.id = id;
            return newObject;
        }
    }
}
