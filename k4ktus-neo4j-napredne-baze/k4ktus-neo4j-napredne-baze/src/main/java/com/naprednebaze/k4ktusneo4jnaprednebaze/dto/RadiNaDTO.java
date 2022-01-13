package com.naprednebaze.k4ktusneo4jnaprednebaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RadiNaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("datum_od")
    private String datum_od;

    @JsonProperty("datum_do")
    private String datum_do;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum_od() {
        return datum_od;
    }

    public void setDatum_od(String datum_od) {
        this.datum_od = datum_od;
    }

    public String getDatum_do() {
        return datum_do;
    }

    public void setDatum_do(String datum_do) {
        this.datum_do = datum_do;
    }
}
