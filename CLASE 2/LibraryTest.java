public class LibraryTest {
    public static void main(String[] args) {
        // Create library
        Library library = new Library(5);
        
        // Add 3 books
        library.addBook(new Book("1984", "Orwell", "123", true));
        library.addBook(new Book("Hamlet", "Shakespeare", "456", true));
        
        // Display all
        library.displayAllBooks();
        
        // Search for a book
        Book found = library.searchByTitle("1984");
        if (found != null) {
            System.out.println("Found: " + found);
        }
        
        // Remove a book
        library.removeBook("123");
        library.displayAllBooks();
    }
}