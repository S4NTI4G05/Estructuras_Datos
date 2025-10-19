/**
 * Clase: Library (Biblioteca)
 * ---------------------------------
 * Esta es la clase principal del proyecto.
 * Aquí se maneja todo lo que pasa en la biblioteca:
 * 
 * 1. Los libros (agregar, editar, eliminar, buscar).
 * 2. Los usuarios (registrar, eliminar, listar, buscar).
 * 3. Los préstamos (prestar, devolver, mostrar historial).
 * 4. El sistema de "Deshacer" (Undo) para revertir acciones.
 *
 * Estructuras usadas:
 * - ArrayList: para listas de libros, usuarios y préstamos.
 * - LinkedList: para el historial de operaciones.
 * - Queue: para la lista de espera de libros ocupados.
 * - Stack: para guardar las acciones que se pueden deshacer.
 *
 * En resumen:
 * - Controla toda la lógica del sistema.
 * - Cada vez que haces algo (agregar, borrar, etc.),
 *   guarda cómo revertirlo si luego usas "Deshacer".
 *
 * Sobre el método Undo:
 * ------------------------
 * Cuando el usuario elige "Deshacer", el sistema toma
 * la última acción guardada en la pila (como si fuera Ctrl+Z)
 * y ejecuta la acción contraria:
 * 
 * Ejemplo:
 *  - Si agregaste un libro, Undo lo borra.
 *  - Si borraste un libro, Undo lo vuelve a crear.
 *  - Si prestaste un libro, Undo lo devuelve.
 * 
 * Esto permite volver atrás paso a paso en orden inverso.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.time.LocalDate;

public class Library {
    // Almacenamiento de datos
    private ArrayList<Book> libros = new ArrayList<Book>();
    private ArrayList<User> usuarios = new ArrayList<User>();
    private ArrayList<Loan> prestamosActivos = new ArrayList<Loan>();
    private LinkedList<String> historialOperaciones = new LinkedList<String>(); // últimas primero
    private Stack<Operation> pilaDeshacer;

    public Library(Stack<Operation> undoStack) {
        this.pilaDeshacer = undoStack;
    }

    // ===== BOOKS =====
    public Book findBook(String isbn) {
        for (int i = 0; i < libros.size(); i++) {
            Book b = libros.get(i);
            if (b.getIsbn().equals(isbn))
                return b;
        }
        return null;
    }

    public void addBook(Book b) {
        libros.add(b);
        // acción inversa para deshacer: eliminar el libro añadido
        pilaDeshacer.push(new Operation(OperationType.REMOVE_BOOK, b.getIsbn(), b.getTitle(),
                b.getAuthor() + "\t" + b.getCategory()));
    }

    public boolean updateBook(String isbn, String newTitle, String newAuthor, String newCategory) {
        Book b = findBook(isbn);
        if (b == null)
            return false;
        String oldTitle = b.getTitle();
        String oldAuthor = b.getAuthor();
        String oldCat = b.getCategory();

        b.setTitle(newTitle);
        b.setAuthor(newAuthor);
        b.setCategory(newCategory);

        // inversa: restaurar campos anteriores
        pilaDeshacer.push(new Operation(OperationType.UPDATE_BOOK, isbn, oldTitle, oldAuthor + "\t" + oldCat));
        return true;
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < libros.size(); i++) {
            Book b = libros.get(i);
            if (b.getIsbn().equals(isbn)) {
                libros.remove(i);
                // inversa: volver a añadir el libro con sus campos
                pilaDeshacer.push(new Operation(OperationType.ADD_BOOK, isbn, b.getTitle(),
                        b.getAuthor() + "\t" + b.getCategory()));
                return true;
            }
        }
        return false;
    }

    public void listBooks() {
        System.out.println("=== Libros ===");
        Iterator<Book> it = libros.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void searchByTitle(String q) {
        for (int i = 0; i < libros.size(); i++) {
            Book b = libros.get(i);
            if (b.getTitle().toLowerCase().indexOf(q.toLowerCase()) >= 0)
                System.out.println(b);
        }
    }

    public void searchByAuthor(String q) {
        Iterator<Book> it = libros.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.getAuthor().toLowerCase().indexOf(q.toLowerCase()) >= 0)
                System.out.println(b);
        }
    }

    public void searchByIsbn(String isbn) {
        Book b = findBook(isbn);
        System.out.println(b == null ? "No encontrado" : b.toString());
    }

    // ===== USERS =====
    public User findUser(String id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id))
                return usuarios.get(i);
        }
        return null;
    }

    public void registerUser(User u) {
        usuarios.add(u);
        // inversa: eliminar usuario registrado
        pilaDeshacer.push(new Operation(OperationType.REMOVE_USER, u.getId(), u.getName(), null));
    }

    public boolean removeUser(String id) {
        for (int i = 0; i < usuarios.size(); i++) {
            User u = usuarios.get(i);
            if (u.getId().equals(id)) {
                usuarios.remove(i);
                // inversa: volver a registrar el usuario eliminado
                pilaDeshacer.push(new Operation(OperationType.REGISTER_USER, u.getId(), u.getName(), null));
                return true;
            }
        }
        return false;
    }

    public void listUsers() {
        System.out.println("=== Usuarios ===");
        Iterator<User> it = usuarios.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

    public void searchUserByName(String q) {
        for (int i = 0; i < usuarios.size(); i++) {
            User u = usuarios.get(i);
            if (u.getName().toLowerCase().indexOf(q.toLowerCase()) >= 0)
                System.out.println(u);
        }
    }

    // ===== LOANS =====
    public boolean borrow(String userId, String isbn) {
        User u = findUser(userId);
        Book b = findBook(isbn);
        if (u == null || b == null) {
            System.out.println("Usuario o libro no encontrado.");
            return false;
        }

        if (b.isAvailable()) {
            b.setAvailable(false);
            prestamosActivos.add(new Loan(userId, isbn));
            u.getLoanHistory().addFirst(isbn);
            historialOperaciones.addFirst("PRESTAR " + userId + " -> " + isbn);

            // inversa: devolver el libro
            pilaDeshacer.push(new Operation(OperationType.RETURN, userId, isbn, null));
            System.out.println("Préstamo OK.");
            return true;
        } else {
            // enqueue reservation
            Queue<String> q = b.getWaitingList();
            q.add(userId);
            historialOperaciones.addFirst("ENCOLAR " + userId + " " + isbn);
            // inversa: eliminar una ocurrencia de la cola
            pilaDeshacer.push(new Operation(OperationType.ENQUEUE_RESERVATION, userId, isbn, null));
            System.out.println("Libro ocupado. Añadido a la lista de espera (pos " + q.size() + ").");
            return false;
        }
    }

    public boolean returnBook(String userId, String isbn) {
        int idx = -1;
        for (int i = 0; i < prestamosActivos.size(); i++) {
            Loan l = prestamosActivos.get(i);
            if (l.getUserId().equals(userId) && l.getIsbn().equals(isbn)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println("Préstamo activo no encontrado.");
            return false;
        }
        prestamosActivos.remove(idx);
        historialOperaciones.addFirst("DEVOLVER " + userId + " <- " + isbn);
        // inversa: volver a prestar
        pilaDeshacer.push(new Operation(OperationType.BORROW, userId, isbn, null));

        Book b = findBook(isbn);
        if (b != null) {
            Queue<String> q = b.getWaitingList(); // usar la cola de IDs de usuario
            if (q == null || q.isEmpty()) {
                b.setAvailable(true);
            } else {
                String nextUser = q.poll();
                b.setAvailable(false);
                prestamosActivos.add(new Loan(nextUser, isbn));
                User nu = findUser(nextUser);
                if (nu != null)
                    nu.getLoanHistory().addFirst(isbn);
                historialOperaciones.addFirst("AUTO_PRESTAR -> " + nextUser + " " + isbn);
            }
        }
        System.out.println("Devolución OK.");
        return true;
    }

    public void listActiveLoans() {
    System.out.println("=== Préstamos activos ===");
        Iterator<Loan> it = prestamosActivos.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

    public void printHistory() {
    System.out.println("=== Historial de operaciones (últimas primero) ===");
        Iterator<String> it = historialOperaciones.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

    // ===== UNDO =====
    public boolean undoLast() {
        String msg = "Deshacer última operación OK. ";
        if (pilaDeshacer.isEmpty()) {
            System.out.println("Nada que deshacer.");
            return false;
        }
        Operation op = pilaDeshacer.pop();
        OperationType t = op.getType();

        if (t == OperationType.REMOVE_BOOK){
            msg += "Libro eliminado: " + op.getA();
            System.out.println(msg);
            return removeBook(op.getA());
        }

        if (t == OperationType.UPDATE_BOOK) {
            String isbn = op.getA();
            String oldTitle = op.getB();
            String pair = op.getC();
            String oldAuthor = "";
            String oldCategory = "";
            int sep = pair.indexOf('\t');
            if (sep >= 0) {
                oldAuthor = pair.substring(0, sep);
                oldCategory = pair.substring(sep + 1);
            }
            msg += "Libro restaurado: " + isbn;
            System.out.println(msg);
            return updateBook(isbn, oldTitle, oldAuthor, oldCategory);
        }

        if (t == OperationType.ADD_BOOK) {
            Book b = new Book(op.getA(), op.getB(), "", "");
            String pair = op.getC();
            int sep = pair.indexOf('\t');
            if (sep >= 0) {
                b.setAuthor(pair.substring(0, sep));
                b.setCategory(pair.substring(sep + 1));
            }
            addBook(b);
            msg += "Libro re-insertado: " + b.getIsbn();
            System.out.println(msg);
            return true;
        }

        if (t == OperationType.REMOVE_USER){
            msg += "Usuario eliminado: " + op.getA();
            System.out.println(msg);
            return removeUser(op.getA());
        }

        if (t == OperationType.REGISTER_USER) {
            registerUser(new User(op.getA(), op.getB()));
            msg += "Usuario re-registrado: " + op.getA();
            System.out.println(msg);
            return true;
        }
        if (t == OperationType.RETURN){
            msg += "Libro devuelto: " + op.getA();
            System.out.println(msg);
            return returnBook(op.getA(), op.getB());
        }
        if (t == OperationType.BORROW){
            msg += "Libro prestado: " + op.getA();
            System.out.println(msg);
            return borrow(op.getA(), op.getB());
        }

        if (t == OperationType.ENQUEUE_RESERVATION) {
            Book b = findBook(op.getB());
            if (b != null) {
                Queue<String> q = b.getWaitingList();
                LinkedList<String> aux = new LinkedList<String>();
                boolean removed = false;
                while (!q.isEmpty()) {
                    String v = q.poll();
                    if (!removed && v.equals(op.getA()))
                        removed = true;
                    else
                        aux.add(v);
                }
                Iterator<String> it = aux.iterator();
                while (it.hasNext())
                    q.add(it.next());
            }
            System.out.println("Deshacer cambio en la cola de reservas.");
            return true;
        }

        System.out.println("Operación desconocida.");
        return false;
    }

    /**
     * Llamar cuando se devuelve un libro para reasignarlo al siguiente en la lista de espera.
     * Ajusta según la estructura de préstamos (Loan) existente en tu proyecto.
     */
    public User assignBookToNextWaitingUser(Book book) {
        if (book == null) return null;
        // Book mantiene una cola de IDs de usuario (String). Usar pollWaitingUser()
        String nextUserId = book.pollWaitingUser();
        if (nextUserId == null) return null;

        // Convertir ID a User usando findUser; el llamador puede crear el Loan.
        return findUser(nextUserId);
    }

    // Llamar assignBookToNextWaitingUser(book) después de procesar la devolución
}
