package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //instanciamos array de objetos book
        List<Book> libros=new ArrayList<>();

        //creamos objetos book
        Book libro1 = new Book("978-1-234567-89-0", "El Gran Gatsby", "F. Scott Fitzgerald", 180, 1925);
        Book libro2 = new Book("978-2-345678-90-1", "Cien años de soledad", "Gabriel García Márquez", 368, 1967);
        Book libro3 = new Book("978-3-456789-01-2", "1984", "George Orwell", 328, 1949);

        //añadimos l,os objetos al array
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);


    }
    //Utiliza la librería Jackson para serializar la lista de libros a un archivo JSON

    public static String escibriListaObjetosaJson(List<Book> libros){
        try{
            ObjectMapper objectMapper=new ObjectMapper();


        }

    }


}