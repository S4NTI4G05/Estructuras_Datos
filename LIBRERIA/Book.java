/**
 * Clase: Book (Libro)
 * -------------------------------
 * Esta clase representa un libro de la biblioteca.
 * Guarda su información básica: ISBN, título, autor y categoría.
 * También sabe si el libro está disponible o prestado.
 * 
 * Además, cada libro tiene una "lista de espera" donde se
 * van guardando los usuarios que quieren pedirlo cuando esté libre.
 *
 * Estructuras usadas:
 * - Queue (cola): para manejar la lista de espera de forma ordenada.
 *
 * En resumen:
 * - Guarda los datos del libro.
 * - Permite saber si está libre o prestado.
 * - Mantiene una cola de usuarios que esperan por el libro.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Book {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria; // categoría simple (String)
    private boolean disponible; // modelo de una copia
    private final Queue<String> colaEspera = new LinkedList<>();

    public Book(String isbn, String title, String author, String category) {
        this.isbn = isbn;
        this.titulo = title;
        this.autor = author;
        this.categoria = category;
        this.disponible = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return titulo;
    }

    public String getAuthor() {
        return autor;
    }

    public String getCategory() {
        return categoria;
    }

    public boolean isAvailable() {
        return disponible;
    }

    public void setTitle(String t) {
        this.titulo = t;
    }

    public void setAuthor(String a) {
        this.autor = a;
    }

    public void setCategory(String c) {
        this.categoria = c;
    }

    public void setAvailable(boolean a) {
        this.disponible = a;
    }

    /**
     * Devuelve la cola interna de espera (IDs de usuario).
     */
    public Queue<String> getWaitingList() {
        return colaEspera;
    }

    /**
     * Añade un ID de usuario a la cola de espera si no está ya.
     */
    public synchronized void enqueueWaitingUser(String userId) {
        if (userId == null) return;
        if (!colaEspera.contains(userId))
            colaEspera.add(userId);
    }

    /**
     * Devuelve y elimina el siguiente ID en la lista de espera, o null si está vacía.
     */
    public synchronized String pollWaitingUser() {
        return colaEspera.poll();
    }

    /**
     * Elimina a un usuario de la lista de espera.
     */
    public synchronized boolean removeWaitingUser(String userId) {
        return colaEspera.remove(userId);
    }

    /**
     * Tamaño de la lista de espera.
     */
    public int getWaitingListSize() {
        return colaEspera.size();
    }

    @Override
    public String toString() {
        return "[ISBN=" + isbn + ", título=" + titulo + ", autor=" + autor +
        ", categoría=" + categoria + ", disponible=" + disponible +
        ", cola=" + colaEspera.size() + "]";
    }
}
