package com.aluracursos.literalura_challenge.repository;

import com.aluracursos.literalura_challenge.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByNombreContainsIgnoreCase(String nombre);

    @Query("SELECT a FROM AuthorEntity a WHERE a.nacimiento <= :anio AND (a.fallecimiento IS NULL OR a.fallecimiento >= :anio)")
    List<AuthorEntity> findAutoresVivosEnAnio(Integer anio);
}
