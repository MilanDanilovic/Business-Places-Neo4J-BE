package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@RelationshipProperties
public class Iznajmljuje {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Firma firma;

    @Property
    private String datum_od;

    @Property
    private String datum_do;

    public Iznajmljuje(Firma firma, String datum_od, String datum_do) {
        this.id = null;
        this.firma = firma;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
    }

    public Iznajmljuje withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Iznajmljuje newObject = new Iznajmljuje(this.firma, this.datum_od, this.datum_do);
            newObject.id = id;
            return newObject;
        }
    }
}
