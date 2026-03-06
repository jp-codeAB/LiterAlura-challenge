package com.aluracursos.literalura_challenge.principal;

import com.aluracursos.literalura_challenge.service.APIConsumer;
import com.aluracursos.literalura_challenge.service.DataConverter;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private APIConsumer apiConsumer = new APIConsumer();
    private static final String URL_BASE = "https://gutendex.com/books/";
    private DataConverter dataConverter = new DataConverter();
    private String json;

    public void mostrarMenu(){
        var opcion = -1;
        while (opcion !=0){
            var menu = """
            --------------------------------------------------
                          Bienvenido a LiterAlura
                          
            Seleccione la opción que desea realizar 📚
            1.- buscar un libro por titulo.
            
            """;
            System.out.println(menu);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroPorTItulo();
                    break;
                case 2:
                default:
                    System.out.println("Opcion Invalida");
            }
        }

    }

    private void buscarLibroPorTItulo() {
        System.out.println("Ingrese el titulo del libro: ");
        String title = sc.nextLine();
        json = apiConsumer.obtenerDatos(URL_BASE+"?search="+title.replace(" ", "+"));
        System.out.println(json);
    }

}
