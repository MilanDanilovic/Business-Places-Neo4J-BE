package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@RelationshipProperties
public class Deo {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final PoslovniProstor poslovniProstor;

    public Deo(PoslovniProstor poslovniProstor) {
        this.id = null;
        this.poslovniProstor = poslovniProstor;
    }

    public Deo withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Deo newObject = new Deo(this.poslovniProstor);
            newObject.id = id;
            return newObject;
        }
    }
}
