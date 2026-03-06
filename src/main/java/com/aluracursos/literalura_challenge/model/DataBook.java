package com.aluracursos.literalura_challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook (
        @JsonAlias("title")
        String titulo,
        @JsonAlias("authors")
        List<DataAuthor> autor,
        @JsonAlias("languages")
        List<String> lenguajes,
        @JsonAlias("download_count")
        Double descargas
){
}
