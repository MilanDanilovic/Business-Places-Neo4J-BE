package com.naprednebaze.k4ktusneo4jnaprednebaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjekatDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("naziv")
    private String naziv;

    @JsonProperty("sifra_projekta")
    private Long sifra_projekta;

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

    public Long getSifra_projekta() {
        return sifra_projekta;
    }

    public void setSifra_projekta(Long sifra_projekta) {
        this.sifra_projekta = sifra_projekta;
    }
}
