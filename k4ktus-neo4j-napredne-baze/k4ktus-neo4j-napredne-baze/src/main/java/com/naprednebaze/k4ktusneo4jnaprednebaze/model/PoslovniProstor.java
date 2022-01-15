package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.List;

@Data
@Node("PoslovniProstor")
public class PoslovniProstor {
    @Id
    @GeneratedValue
    private Long id;
    private Double kvadratura;
    private String adresa;
    private Long idVlasnika;

    @Relationship(type = "Sadrzi" , direction = Relationship.Direction.OUTGOING)
    private List<Kancelarija> kancelarije;

    public PoslovniProstor(Double kvadratura, String adresa, List<Kancelarija> kancelarije, Long idVlasnika) {
        this.id = null;
        this.kvadratura = kvadratura;
        this.adresa = adresa;
        this.kancelarije = kancelarije;
        this.idVlasnika = idVlasnika;
    }

    public PoslovniProstor() {

    }

    public PoslovniProstor withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            PoslovniProstor newObject = new PoslovniProstor(this.kvadratura, this.adresa, this.kancelarije, this.idVlasnika);
            newObject.id = id;
            return newObject;
        }
    }
}
