package com.aluracursos.literalura_challenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BookEntity> libros;

    public AuthorEntity() {}

    public AuthorEntity(AuthorData data) {
        this.nombre = data.nombre();
        this.nacimiento = data.nacimiento();
        this.fallecimiento = data.fallecimiento();
    }

    @Override
    public String toString() {
        return String.format("""
                ******* AUTOR *******
                Nombre: %s
                Fecha de nacimiento: %s
                Fecha de fallecimiento: %s
                Libros: %s
                *********************
                """, nombre, nacimiento, fallecimiento,
                libros.stream().map(BookEntity::getTitulo).toList());
    }
    // Getters y Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public List<BookEntity> getLibros() {
        return libros;
    }

    public void setLibros(List<BookEntity> libros) {
        this.libros = libros;
    }
}