/**
 * Clase: User (Usuario)
 * -------------------------------
 * Representa a una persona que usa la biblioteca.
 * Cada usuario tiene un número de identificación (id) y un nombre.
 * 
 * Además, cada usuario guarda su "historial de préstamos",
 * es decir, los libros que ha pedido prestados antes.
 *
 * Estructuras usadas:
 * - LinkedList: para guardar los ISBN de los libros que ha tenido.
 *
 * En resumen:
 * - Guarda la información básica del usuario.
 * - Mantiene un registro de los libros que ha pedido.
 */

import java.util.LinkedList;

public class User {
    private String id;
    private String nombre;
    private LinkedList<String> historialPrestamos = new LinkedList<String>();

    public User(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    // Conservamos el nombre del método público para no romper llamadas externas
    public String getName() {
        return nombre;
    }

    // Conservamos la firma pública setName()
    public void setName(String n) {
        this.nombre = n;
    }

    // Conservamos la firma pública getLoanHistory()
    public LinkedList<String> getLoanHistory() {
        return historialPrestamos;
    }

    public String toString() {
        return "[id=" + id + ", nombre=" + nombre + ", historial=" + historialPrestamos.size() + "]";
    }
}
