package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;

@Data
@RelationshipProperties
public class Poseduje {

    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Vlasnik vlasnik;

    @Property
    private LocalDate datum_kupovine;

    public Poseduje(Vlasnik vlasnik, LocalDate datum_kupovine) {
        this.id = null;
        this.datum_kupovine = datum_kupovine;
        this.vlasnik = vlasnik;
    }

    public Poseduje withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Poseduje newObject = new Poseduje(this.vlasnik, this.datum_kupovine);
            newObject.id = id;
            return newObject;
        }
    }
}
