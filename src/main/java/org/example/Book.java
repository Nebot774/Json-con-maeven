package org.example;


public class Book {
    private String isbn;
    private String titulo;
    private String autor;
    private int numPaginas;
    private int anoPublicacion;

    // Constructor sin argumentos
    public Book() {
    }

    // Constructor con argumentos
    public Book(String isbn, String titulo, String autor, int numPaginas, int anoPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.anoPublicacion = anoPublicacion;
    }

    // Getters y Setters para los atributos
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }




}