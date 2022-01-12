package com.naprednebaze.k4ktusneo4jnaprednebaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PoslovniProstorDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("kvadratura")
    private Double kvadratura;

    @JsonProperty("adresa")
    private String adresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(Double kvadratura) {
        this.kvadratura = kvadratura;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
