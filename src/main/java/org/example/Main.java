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
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

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

        //llamamos al metodo escibriListaObjetosaJson para convertir la lista de objetos en un fichero JSON
        String jsonContenido=escibriListaObjetosaJson(libros);

        FileWriter archivo=new FileWriter("/home/adrcle/IdeaProjects/JSON_maeven/listaObjetosaJson.json");
            archivo.write(jsonContenido);
            archivo.write("\n");
            archivo.close();


        //deserializamos el json en una lista de libros
        //creamos un path de la ruta del json
        Path ficheroArrayObjetosJson=Path.of("/home/adrcle/IdeaProjects/JSON_maeven/listaObjetosaJson.json");

        List<Book> libros2=leerJsonConvertirObjetos(ficheroArrayObjetosJson);



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



}