package CLASE2;

public class Library {
    private Book[] books;
    private int bookCount;  // Why do we need this?
    
    public Library(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }
    public Book searchByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
    public boolean addBook(Book book) {
        // Check if there's space
        if (bookCount >= books.length) {
            return false;  // No space to add book
        }
        // Check book is not null
        if (book == null) {
            return false;  // Invalid book
        }
        // Add at position bookCount
        books[bookCount] = book;
        // Increment bookCount
        // Return true/false
    }
    public boolean removeBook(String isbn) {
        // Find the book
        // Shift all books after it to the left (no gaps!)
        // Decrement bookCount
        // Return true/false
    }
    public void displayAllBooks() {
        // Show count: "Library has X of Y books"
        // Print each book (only up to bookCount)
        // Handle empty library case
    }
}


