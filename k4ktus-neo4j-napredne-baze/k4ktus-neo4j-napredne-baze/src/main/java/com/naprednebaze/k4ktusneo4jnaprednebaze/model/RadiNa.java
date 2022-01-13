package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

@Data
@RelationshipProperties
public class RadiNa {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Firma firma;

    @Property
    private String datum_od;

    @Property
    private String datum_do;

    public RadiNa(Firma firma, String datum_od, String datum_do) {
        this.id = null;
        this.firma = firma;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
    }

    public RadiNa withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            RadiNa newObject = new RadiNa(this.firma, this.datum_od, this.datum_do);
            newObject.id = id;
            return newObject;
        }
    }
}
