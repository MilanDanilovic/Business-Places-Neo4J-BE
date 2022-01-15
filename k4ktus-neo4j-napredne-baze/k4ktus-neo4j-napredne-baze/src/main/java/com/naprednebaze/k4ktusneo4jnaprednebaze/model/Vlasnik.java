package com.naprednebaze.k4ktusneo4jnaprednebaze.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Node("Vlasnik")
public class Vlasnik {
    @Id
    @GeneratedValue
    private Long id; //graphId
    private String ime;
    private String prezime;
    private String datum_rodjenja;
    private Long jmbg;
    private String broj_telefona;

    @Relationship(type = "Poseduje" , direction = Relationship.Direction.OUTGOING)
    private List<PoslovniProstor> poslovniProstori;



    public Vlasnik(String ime, String prezime,String datum_rodjenja, Long jmbg, String broj_telefona, List<PoslovniProstor> poslovniProstori) {
        this.id = null;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja;
        this.jmbg = jmbg;
        this.broj_telefona = broj_telefona;
        this.poslovniProstori = poslovniProstori;
    }

    /*
        	This is a so-called wither for the id-attribute.
            It creates a new entity and sets the field accordingly, without modifying the original entity,
            thus making it immutable.
     */

    public void addPoslovniProstor(PoslovniProstor poslovniProstor){
        if(this.poslovniProstori == null){
            this.poslovniProstori = new ArrayList<>();
        }
        this.poslovniProstori.add(poslovniProstor);
    }

    public Vlasnik withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Vlasnik newObject = new Vlasnik(this.ime, this.prezime, this.datum_rodjenja, this.jmbg, this.broj_telefona, this.poslovniProstori);
            newObject.id = id;
            return newObject;
        }
    }
}
