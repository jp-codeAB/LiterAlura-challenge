package com.aluracursos.literalura_challenge.principal;

import com.aluracursos.literalura_challenge.model.BookData;
import com.aluracursos.literalura_challenge.model.ResultsData;
import com.aluracursos.literalura_challenge.repository.AuthorRepository;
import com.aluracursos.literalura_challenge.repository.BookRepository;
import com.aluracursos.literalura_challenge.service.APIConsumer;
import com.aluracursos.literalura_challenge.service.DataConverter;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private APIConsumer apiConsumer = new APIConsumer();
    private static final String URL_BASE = "https://gutendex.com/books/";
    private DataConverter dataConverter = new DataConverter();
    private String json;
    private BookRepository bookRepo;
    private AuthorRepository authorRepo;

    public Menu(BookRepository br, AuthorRepository ar) {
        this.bookRepo = br;
        this.authorRepo = ar;
    }

    public void mostrarMenu(){
        var opcion = -1;
        while (opcion != 0) {
            System.out.println("""
            --------------------------------------------------
                          Bienvenido a LiterAlura 📚
            --------------------------------------------------
            1 - Buscar libro por título (API y Guardar)
            2 - Listar libros registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en determinado año
            5 - Listar libros por idioma
            0 - Salir
            """);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> buscarLibroWeb();
                case 2 -> listarLibros();
                case 3 -> listarAutores();
                case 4 -> autoresVivosPorAnio();
                case 5 -> listarLibrosPorIdioma();
                case 0 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void buscarLibroWeb() {
    }

    private void listarLibros() {
    }

    private void listarAutores() {
    }

    private void autoresVivosPorAnio() {
    }

    private void listarLibrosPorIdioma() {
    }
}
