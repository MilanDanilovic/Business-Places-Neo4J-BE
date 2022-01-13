package com.naprednebaze.k4ktusneo4jnaprednebaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PosedujeDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("datum_kupovine")
    private String datum_kupovine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum_kupovine() {
        return datum_kupovine;
    }

    public void setDatum_kupovine(String datum_kupovine) {
        this.datum_kupovine = datum_kupovine;
    }
}
