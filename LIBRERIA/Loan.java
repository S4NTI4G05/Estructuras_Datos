/**
 * Clase: Loan (Préstamo)
 * -------------------------------
 * Representa un préstamo activo entre un usuario y un libro.
 * 
 * Solo guarda dos datos:
 *  - userId: quién tiene el libro.
 *  - isbn: qué libro tiene.
 *
 * En resumen:
 * - Sirve para saber qué usuario tiene prestado cada libro.
 */

 public class Loan {
    private String usuarioId;
    private String isbn;

    public Loan(String usuarioId, String isbn) {
        this.usuarioId = usuarioId;
        this.isbn = isbn;
    }

    public String getUserId() {
        return usuarioId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toString() {
        return "[Préstamo usuario=" + usuarioId + ", isbn=" + isbn + "]";
    }
}
