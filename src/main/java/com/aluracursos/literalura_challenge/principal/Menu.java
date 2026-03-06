package com.aluracursos.literalura_challenge.principal;

import com.aluracursos.literalura_challenge.service.APIConsumer;
import com.aluracursos.literalura_challenge.service.DataConverter;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private APIConsumer apiConsumer = new APIConsumer();
    private static final String URL_BASE = "https://gutendex.com/books";
    private DataConverter convierteDatos = new DataConverter();

    private String menu = """
            --------------------------------------------------
                          Bienvenido a LiterAlura
                          
            Seleccione la opción que desea realizar 📚
            1.- buscar un libro por titulo.
            
            """;

    private void mostrarMenu(){
        System.out.println(menu);
    }

    public void run(){
        mostrarMenu();
    }
}
