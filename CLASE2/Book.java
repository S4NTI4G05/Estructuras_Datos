package CLASE2;

public class Book {
    private String title;
    private String author;
    private String isbn; 
    private boolean available;
    
    // Constructor
    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }
    
    // Add getters and setters
    // Add a toString() method to display book info
}