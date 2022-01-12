package com.naprednebaze.k4ktusneo4jnaprednebaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FirmaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("naziv")
    private String naziv;

    @JsonProperty("godisnja_zarada")
    private Double godisnja_zarada;

    @JsonProperty("pib")
    private Long pib;

    @JsonProperty("datum_osnivanja")
    private String datum_osnivanja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getGodisnja_zarada() {
        return godisnja_zarada;
    }

    public void setGodisnja_zarada(Double godisnja_zarada) {
        this.godisnja_zarada = godisnja_zarada;
    }

    public Long getPib() {
        return pib;
    }

    public void setPib(Long pib) {
        this.pib = pib;
    }

    public String getDatum_osnivanja() {
        return datum_osnivanja;
    }

    public void setDatum_osnivanja(String datum_osnivanja) {
        this.datum_osnivanja = datum_osnivanja;
    }
}
