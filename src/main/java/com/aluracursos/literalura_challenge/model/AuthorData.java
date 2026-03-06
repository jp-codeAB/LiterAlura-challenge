package com.aluracursos.literalura_challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorData(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("birth_year")
        Integer nacimeinto,
        @JsonAlias("death_year")
        Integer fallecimiento
){
}
