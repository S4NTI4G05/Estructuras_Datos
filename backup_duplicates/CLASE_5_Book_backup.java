/* Respaldo: CLASE 5 - Book */
class CLASE_5_Book_backup {
    String name;
    String author;
    String isbn;
    String category;

    public CLASE_5_Book_backup(String name, String author, String isbn, String category){
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    public CLASE_5_Book_backup () {
        super();
    }

    public String toString(){
        return "Book name : " +name + " | Book Author : " +
         author + " |  Book isbn :" + isbn + " | Book category : " +  category;
    }
}
