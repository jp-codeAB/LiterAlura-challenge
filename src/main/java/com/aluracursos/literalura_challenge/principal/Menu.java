package com.aluracursos.literalura_challenge.principal;

import com.aluracursos.literalura_challenge.model.*;
import com.aluracursos.literalura_challenge.repository.AuthorRepository;
import com.aluracursos.literalura_challenge.repository.BookRepository;
import com.aluracursos.literalura_challenge.service.APIConsumer;
import com.aluracursos.literalura_challenge.service.DataConverter;

import java.util.Optional;
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
        System.out.println("Ingrese el título del Libro que deseas buscar:");
        var titulo = sc.nextLine();
        String json = apiConsumer.obtenerDatos(URL_BASE + "?search=" + titulo.replace(" ", "+"));
        var datos = dataConverter.obtenerDatos(json, ResultsData.class);

        Optional<BookData> libroBuscado = datos.libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(titulo.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            BookData d = libroBuscado.get();
            // Lógica de persistencia
            if (bookRepo.findByTituloContainsIgnoreCase(d.titulo()).isPresent()) {
                System.out.println("El libro ya está registrado.");
            } else {
                BookEntity libro = new BookEntity(d);
                AuthorData dAutor = d.autor().get(0);
                // Buscar si el autor ya existe para no duplicarlo
                AuthorEntity autor = authorRepo.findByNombreContainsIgnoreCase(dAutor.nombre())
                        .orElseGet(() -> authorRepo.save(new AuthorEntity(dAutor)));

                libro.setAutor(autor);
                bookRepo.save(libro);
                System.out.println(libro);
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
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
