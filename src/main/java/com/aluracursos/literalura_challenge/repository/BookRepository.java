package com.aluracursos.literalura_challenge.repository;

import com.aluracursos.literalura_challenge.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByIdioma(Idioma idioma);
    Optional<BookEntity> findByTituloContainsIgnoreCase(String titulo);
}