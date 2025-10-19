/**
 * Versión de respaldo de CLASE 5/Book.java
 */
public class Book {
    String name;
    String author;
    String isbn;
    String category;

    public Book(String name, String author, String isbn, String category){
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    public Book () {
        super();
    }

    public String toString(){
        return "Book name : " +name + " | Book Author : " +
         author + " |  Book isbn :" + isbn + " | Book category : " +  category;
    }
}
