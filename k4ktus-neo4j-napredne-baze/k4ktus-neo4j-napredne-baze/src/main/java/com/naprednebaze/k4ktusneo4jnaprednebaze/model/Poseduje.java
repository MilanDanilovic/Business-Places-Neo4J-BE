package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.*;

@Data
@RelationshipProperties
@RelationshipEntity("Poseduje")
public class Poseduje {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String datum_kupovine;

    @TargetNode
    private PoslovniProstor poslovniProstor;

    public Poseduje(PoslovniProstor poslovniProstor, String datum_kupovine) {
        this.id = null;
        this.datum_kupovine = datum_kupovine;
        this.poslovniProstor = poslovniProstor;
    }

    public Poseduje withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Poseduje newObject = new Poseduje(this.poslovniProstor, this.datum_kupovine);
            newObject.id = id;
            return newObject;
        }
    }
}
