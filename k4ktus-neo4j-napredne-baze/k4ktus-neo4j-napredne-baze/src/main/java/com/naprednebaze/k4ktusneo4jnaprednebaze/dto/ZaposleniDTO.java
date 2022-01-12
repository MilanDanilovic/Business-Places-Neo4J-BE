package com.naprednebaze.k4ktusneo4jnaprednebaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZaposleniDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("ime")
    private String ime;

    @JsonProperty("prezime")
    private String prezime;

    @JsonProperty("datum_rodjenja")
    private String datum_rodjenja;

    @JsonProperty("pol")
    private String pol;

    @JsonProperty("jmbg")
    private Long jmbg;

    @JsonProperty("kartica")
    private Long kartica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(String datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public Long getJmbg() {
        return jmbg;
    }

    public void setJmbg(Long jmbg) {
        this.jmbg = jmbg;
    }

    public Long getKartica() {
        return kartica;
    }

    public void setKartica(Long kartica) {
        this.kartica = kartica;
    }
}
