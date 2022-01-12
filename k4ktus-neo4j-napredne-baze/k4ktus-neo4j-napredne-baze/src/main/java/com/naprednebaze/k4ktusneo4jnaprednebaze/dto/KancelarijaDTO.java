package com.naprednebaze.k4ktusneo4jnaprednebaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KancelarijaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("broj_kancelarije")
    private Long broj_kancelarije;

    @JsonProperty("kvadratura")
    private Double kvadratura;

    @JsonProperty("broj_radnika")
    private Long broj_radnika;

    @JsonProperty("status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBroj_kancelarije() {
        return broj_kancelarije;
    }

    public void setBroj_kancelarije(Long broj_kancelarije) {
        this.broj_kancelarije = broj_kancelarije;
    }

    public Double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(Double kvadratura) {
        this.kvadratura = kvadratura;
    }

    public Long getBroj_radnika() {
        return broj_radnika;
    }

    public void setBroj_radnika(Long broj_radnika) {
        this.broj_radnika = broj_radnika;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
