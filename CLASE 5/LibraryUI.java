import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase principal de la interfaz de usuario para la biblioteca.
 * Permite al usuario interactuar con el sistema de gestión de libros mediante menús en consola.
 * 
 * Funcionalidades principales:
 * - Mostrar menú principal con opciones para gestionar libros y usuarios.
 * - Navegar por el menú de libros para agregar, buscar, listar, actualizar y eliminar libros.
 * - Solicitar información de libros al usuario.
 * 
 * Uso:
 * Ejecuta el método main para iniciar la aplicación y navegar por los menús.
 */
public class LibraryUI {

    /**
     * Método principal que inicia la aplicación de la biblioteca.
     * Crea una instancia de Library y gestiona el ciclo principal de menús.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main (String[] args){
        try {
            Library myLibrary = new Library();
            Scanner input = new Scanner(System.in);
            String opts="";
            // Ciclo principal: muestra el menú hasta que el usuario elija salir ('z')
            do{
                opts = showMainMenu(input, myLibrary);
            }while(!opts.equalsIgnoreCase("z"));
        } catch (Exception e) {
            // Manejo básico de excepciones (puede mejorarse)
        }
    }

    /**
     * Muestra el menú principal de la biblioteca y gestiona la navegación.
     * Permite al usuario elegir entre gestionar libros, usuarios (no implementado), otra opción o salir.
     * 
     * @param input Scanner para leer la entrada del usuario.
     * @param myLibrary Instancia de la biblioteca para operar sobre ella.
     * @return La opción elegida por el usuario.
     */
    public static String showMainMenu(Scanner input, Library myLibrary){
        System.out.println("Welcome to my library");
        System.out.println("pick an option:");
        System.out.println("a -> Books");
        System.out.println("b -> Users (not implement yet)");
        System.out.println("c -> whatever");
        System.out.println("z -> Exit");
        String opts = "";
        boolean isValidOption = false;
        // Ciclo para mantener el menú hasta que el usuario decida salir
        do {
            opts = input.nextLine();
            switch (opts) {
                case "a":
                    // Navega al menú de libros
                    showBookMenu(input,myLibrary);
                    break;
                case "b":
                case "c":
                case "z":
                    // Opciones válidas, no requieren acción adicional aquí
                    break;
                default:
                    System.out.println("Input a valid option");
                    break;
            }
        }while(!opts.equalsIgnoreCase("z"));
        return opts;
    }

    /**
     * Muestra el menú de gestión de libros y permite realizar operaciones sobre ellos.
     * Opciones: agregar, buscar, listar, actualizar, eliminar libros, volver atrás o salir.
     * 
     * @param input Scanner para leer la entrada del usuario.
     * @param myLibrary Instancia de la biblioteca para operar sobre ella.
     * @return La opción elegida por el usuario.
     */
    public static String showBookMenu(Scanner input, Library myLibrary){
        System.out.println("Books Menu");
        System.out.println("pick an option:");
        System.out.println("a -> add Books");
        System.out.println("b -> search Book");
        System.out.println("c -> list Books");
        System.out.println("d -> update Book");
        System.out.println("e -> delete Book");
        System.out.println("f -> Back");
        System.out.println("z -> Exit");
        String opts = "";
        boolean isValidOption = false;
        // Ciclo para mantener el menú de libros hasta que el usuario decida volver o salir
        do {
            opts = input.nextLine();
            switch (opts) {
                case "a":
                    // Solicita información y agrega un nuevo libro
                    Book newBook = getBookInformation(input);
                    myLibrary.addBook(newBook);
                    break;
                case "b":
                case "c":
                case "d":
                case "e":
                case "f":
                case "z":
                    // Opciones válidas, no requieren acción adicional aquí
                    break;
                default:
                    System.out.println("Input a valid option");
                    break;
            }
        }while(!opts.equalsIgnoreCase("z") && !opts.equalsIgnoreCase("f"));
        return opts;
    }

    /**
     * Solicita al usuario la información necesaria para crear un nuevo libro.
     * 
     * @param input Scanner para leer la entrada del usuario.
     * @return Instancia de Book creada con los datos proporcionados.
     */
    public static Book getBookInformation (Scanner input){
        System.out.println("Book name : ");
        String name = input.nextLine();
        System.out.println("Book author : ");
        String author = input.nextLine();
        System.out.println("Book isbn : ");
        String isbn = input.nextLine();
        System.out.println("Book cateogry : ");
        String category = input.nextLine();

        Book book = new Book(name,author,isbn,category);
        return book;
    }
}