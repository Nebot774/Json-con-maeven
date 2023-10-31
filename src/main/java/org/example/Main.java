package org.example;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        // Instanciamos un array de objetos Book
        List<Book> libros = new ArrayList<>();

        // Creamos objetos Book iniciales
        Book libro1 = new Book("978-1-234567-89-0", "El Gran Gatsby", "F. Scott Fitzgerald", 180, 1925);
        Book libro2 = new Book("978-2-345678-90-1", "Cien años de soledad", "Gabriel García Márquez", 368, 1967);
        Book libro3 = new Book("978-3-456789-01-2", "1984", "George Orwell", 328, 1949);

        // Agregamos los objetos al array
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un nuevo libro");
            System.out.println("2. Buscar libros por título o autor");
            System.out.println("3. Ver la lista de todos los libros");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = teclado.nextInt();
            teclado.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los detalles del nuevo libro:");

                    System.out.print("ISBN: ");
                    String isbn = teclado.nextLine();

                    System.out.print("Título: ");
                    String titulo = teclado.nextLine();

                    System.out.print("Autor: ");
                    String autor = teclado.nextLine();

                    System.out.print("Número de páginas: ");
                    int numPaginas = teclado.nextInt();
                    teclado.nextLine(); // Consumir la nueva línea

                    System.out.print("Año de publicación: ");
                    int añoPublicacion = teclado.nextInt();
                    teclado.nextLine(); // Consumir la nueva línea

                    Book nuevoLibro = new Book(isbn, titulo, autor, numPaginas, añoPublicacion);
                    libros.add(nuevoLibro);

                    break;
                case 2:
                    System.out.print("Ingrese un título o autor para buscar libros: ");
                    String consulta = teclado.nextLine();
                    buscarLibrosPorTituloOAutor(libros, consulta);
                    break;
                case 3:
                    System.out.println("Lista de todos los libros:");
                    for (Book libro : libros) {
                        System.out.println("ISBN: " + libro.getIsbn());
                        System.out.println("Título: " + libro.getTitulo());
                        System.out.println("Autor: " + libro.getAutor());
                        System.out.println("Número de páginas: " + libro.getNumPaginas());
                        System.out.println("Año de publicación: " + libro.getAnoPublicacion());
                        System.out.println();
                    }
                    break;
                case 4:
                    // Guardar la lista de libros en un archivo JSON antes de salir
                    String jsonContenido = escibriListaObjetosaJson(libros);
                    Path path = Paths.get("listaObjetos.json");
                    try {
                        Files.write(path, jsonContenido.getBytes());
                        System.out.println("¡Hasta luego!");
                        System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    //Utiliza la librería Jackson para serializar la lista de libros a un archivo JSON

    public static String escibriListaObjetosaJson(List<Book> libros){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(libros);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Book> leerJsonConvertirObjetos(Path ruta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // return objectMapper.readValue(ruta.toFile(), new TypeReference<List<Lenguaje>>() { });
            return objectMapper.readValue(ruta.toFile(), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    //función que permita buscar libros por título o autor y mostrar los resultados.
    public static void buscarLibrosPorTituloOAutor(List<Book> libros, String consulta) {
        System.out.println("Resultados de la búsqueda para '" + consulta + "':");
        for (Book libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(consulta.toLowerCase()) ||
                    libro.getAutor().toLowerCase().contains(consulta.toLowerCase())) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());

            }
        }


    }

}