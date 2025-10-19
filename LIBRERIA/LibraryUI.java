/**
 * Clase: LibraryUI (Interfaz de Usuario)
 * --------------------------------------
 * Esta clase muestra los menús en la consola
 * y permite que el usuario use el sistema.
 * 
 * Desde aquí se pueden hacer las acciones principales:
 *  - Administrar libros (agregar, editar, eliminar, buscar).
 *  - Registrar o eliminar usuarios.
 *  - Prestar y devolver libros.
 *  - Usar la opción "Deshacer" para revertir la última acción.
 *
 * El programa funciona con un menú por consola:
 *  1. Libros
 *  2. Usuarios
 *  3. Préstamos
 *  4. Deshacer
 *  0. Salir
 *
 * En resumen:
 * - Es la parte visible del programa.
 * - Se encarga de hablar con el usuario y pedirle opciones.
 * - Llama a la clase Library para hacer las acciones.
 */

import java.util.Scanner;
import java.util.Stack;

public class LibraryUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Operation> undo = new Stack<Operation>();
        Library lib = new Library(undo);

        boolean running = true;
        while (running) {
            System.out.println("\n==== Menú Biblioteca ====");
            System.out.println("1) Libros");
            System.out.println("2) Usuarios");
            System.out.println("3) Préstamos");
            System.out.println("4) Deshacer última operación");
            System.out.println("0) Salir");
            System.out.print("Elige: ");
            String opt = sc.nextLine();

            if ("1".equals(opt))
                booksMenu(sc, lib);
            else if ("2".equals(opt))
                usersMenu(sc, lib);
            else if ("3".equals(opt))
                loansMenu(sc, lib);
            else if ("4".equals(opt))
                lib.undoLast();
            else if ("0".equals(opt))
                running = false;
            else
                System.out.println("Opción inválida.");
        }
        sc.close();
        System.out.println("¡Adiós!");
    }

    private static void booksMenu(Scanner sc, Library lib) {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Libros --");
            System.out.println("1) Agregar");
            System.out.println("2) Actualizar");
            System.out.println("3) Eliminar");
            System.out.println("4) Listar");
            System.out.println("5) Buscar por título");
            System.out.println("6) Buscar por autor");
            System.out.println("7) Buscar por ISBN");
            System.out.println("0) Volver");
            System.out.print("Elige: ");
            String o = sc.nextLine();

            if ("1".equals(o)) {
                System.out.print("ISBN: ");
                String isbn = sc.nextLine();
                System.out.print("Título: ");
                String title = sc.nextLine();
                System.out.print("Autor: ");
                String author = sc.nextLine();
                System.out.print("Categoría: ");
                String cat = sc.nextLine();
                lib.addBook(new Book(isbn, title, author, cat));
            } else if ("2".equals(o)) {
                System.out.print("ISBN a actualizar: ");
                String isbn = sc.nextLine();
                System.out.print("Nuevo título: ");
                String title = sc.nextLine();
                System.out.print("Nuevo autor: ");
                String author = sc.nextLine();
                System.out.print("Nueva categoría: ");
                String cat = sc.nextLine();
                if (!lib.updateBook(isbn, title, author, cat))
                    System.out.println("No encontrado.");
            } else if ("3".equals(o)) {
                System.out.print("ISBN a eliminar: ");
                String isbn = sc.nextLine();
                if (!lib.removeBook(isbn))
                    System.out.println("No encontrado.");
            } else if ("4".equals(o)) {
                lib.listBooks();
            } else if ("5".equals(o)) {
                System.out.print("Título contiene: ");
                String q = sc.nextLine();
                lib.searchByTitle(q);
            } else if ("6".equals(o)) {
                System.out.print("Autor contiene: ");
                String q = sc.nextLine();
                lib.searchByAuthor(q);
            } else if ("7".equals(o)) {
                System.out.print("ISBN: ");
                String q = sc.nextLine();
                lib.searchByIsbn(q);
            } else if ("0".equals(o))
                back = true;
            else
                System.out.println("Opción inválida.");
        }
    }

    private static void usersMenu(Scanner sc, Library lib) {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Usuarios --");
            System.out.println("1) Registrar");
            System.out.println("2) Eliminar");
            System.out.println("3) Listar");
            System.out.println("4) Buscar por nombre");
            System.out.println("0) Volver");
            System.out.print("Elige: ");
            String o = sc.nextLine();

            if ("1".equals(o)) {
                System.out.print("ID de usuario: ");
                String id = sc.nextLine();
                System.out.print("Nombre: ");
                String name = sc.nextLine();
                lib.registerUser(new User(id, name));
            } else if ("2".equals(o)) {
                System.out.print("ID de usuario a eliminar: ");
                String id = sc.nextLine();
                if (!lib.removeUser(id))
                    System.out.println("No encontrado.");
            } else if ("3".equals(o)) {
                lib.listUsers();
            } else if ("4".equals(o)) {
                System.out.print("Nombre contiene: ");
                String q = sc.nextLine();
                lib.searchUserByName(q);
            } else if ("0".equals(o))
                back = true;
            else
                System.out.println("Opción inválida.");
        }
    }

    private static void loansMenu(Scanner sc, Library lib) {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Préstamos --");
            System.out.println("1) Prestar");
            System.out.println("2) Devolver");
            System.out.println("3) Listar préstamos activos");
            System.out.println("4) Historial");
            System.out.println("0) Volver");
            System.out.print("Elige: ");
            String o = sc.nextLine();

            if ("1".equals(o)) {
                System.out.print("ID de usuario: ");
                String uid = sc.nextLine();
                System.out.print("ISBN: ");
                String isbn = sc.nextLine();
                lib.borrow(uid, isbn);
            } else if ("2".equals(o)) {
                System.out.print("ID de usuario: ");
                String uid = sc.nextLine();
                System.out.print("ISBN: ");
                String isbn = sc.nextLine();
                lib.returnBook(uid, isbn);
            } else if ("3".equals(o)) {
                lib.listActiveLoans();
            } else if ("4".equals(o)) {
                lib.printHistory();
            } else if ("0".equals(o))
                back = true;
            else
                System.out.println("Opción inválida.");
        }
    }
}
