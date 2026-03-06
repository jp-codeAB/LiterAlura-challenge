package com.aluracursos.literalura_challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public record Book (
        @JsonAlias("title")
        String titulo,
        @JsonAlias("authors")
        List<Author> autor,
        @JsonAlias("languages")
        List<String> lenguajes,
        @JsonAlias("download_count")
        Double descargas
){
}
