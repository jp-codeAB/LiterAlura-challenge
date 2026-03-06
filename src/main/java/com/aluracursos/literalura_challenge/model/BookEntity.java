package com.aluracursos.literalura_challenge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Double descargas;

    @ManyToOne
    private AuthorEntity autor;

    public BookEntity() {}

    public BookEntity(BookData data) {
        this.titulo = data.titulo();
        this.idioma = Idioma.fromString(data.lenguajes().get(0));
        this.descargas = data.descargas();
    }

    @Override
    public String toString() {
        return String.format("""
                ------- LIBRO -------
                Título: %s
                Autor: %s
                Idioma: %s
                Descargas: %.1f
                ---------------------
                """, titulo, (autor != null ? autor.getNombre() : "Desconocido"), idioma, descargas);
    }
    // Getters y Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    public AuthorEntity getAutor() {
        return autor;
    }

    public void setAutor(AuthorEntity autor) {
        this.autor = autor;
    }
}
