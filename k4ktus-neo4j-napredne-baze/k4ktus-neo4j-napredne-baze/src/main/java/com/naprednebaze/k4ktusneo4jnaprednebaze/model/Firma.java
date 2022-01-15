package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.List;

@Data
@Node("Firma")
public class Firma {
    @Id
    @GeneratedValue
    private Long id;
    private String naziv;
    private Double godisnja_zarada;
    private Long pib;
    private String datum_osnivanja;
    private Long idKancelarije;

    @Relationship(type = "Rade" , direction = Relationship.Direction.INCOMING)
    private List<Zaposleni> zaposleni;

    @Relationship(type = "RadiNa" , direction = Relationship.Direction.OUTGOING)
    private List<Projekat> projekti;

    public Firma(String naziv, Double godisnja_zarada, Long pib, List<Zaposleni> zaposleni, String datum_osnivanja, List<Projekat> projekti, Long idKancelarije) {
        this.id = null;
        this.naziv = naziv;
        this.godisnja_zarada = godisnja_zarada;
        this.pib = pib;
        this.zaposleni = zaposleni;
        this.datum_osnivanja = datum_osnivanja;
        this.projekti = projekti;
        this.idKancelarije = idKancelarije;
    }

    public Firma withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Firma newObject = new Firma(this.naziv, this.godisnja_zarada, this.pib, this.zaposleni, this.datum_osnivanja, this.projekti, this.idKancelarije);
            newObject.id = id;
            return newObject;
        }
    }
}
