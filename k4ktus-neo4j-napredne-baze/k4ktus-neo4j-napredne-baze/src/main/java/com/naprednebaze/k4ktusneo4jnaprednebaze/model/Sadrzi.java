package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@RelationshipProperties
public class Sadrzi {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Kancelarija kancelarija;

    public Sadrzi(Kancelarija kancelarija) {
        this.id = null;
        this.kancelarija = kancelarija;
    }

    public Sadrzi withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Sadrzi newObject = new Sadrzi(this.kancelarija);
            newObject.id = id;
            return newObject;
        }
    }
}
