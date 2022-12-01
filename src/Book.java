public class Book {
    private String book_name;
    private int ISBN;
    private String SISBN;
    private String author;
    private String publisher;
    private String date;

    // overrides toString
    public String toString(){
        return this.book_name + ", " + this.ISBN + ", " + this.author + ", " + this.publisher + ", " + this.date;
    }

    // Default parameter that returns a dummy book
    Book(){
        this("Dummy ConsoleApp.Book", "John Doe", "John Publishing", "May 13 2004");
    }

    Book(String book_name){
        this.book_name = book_name;
    }

    Book(int ISBN){
        this.ISBN = ISBN;
    }

    Book(String book_name, int ISBN){
        this.book_name = book_name;
        this.ISBN = ISBN;
    }

    Book(String book_name, String author, String publisher, String date){
        this.book_name = book_name;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
    }
    Book(String book_name, int ISBN, String author, String publisher, String date){
        this.book_name = book_name;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
    }

    // set methods
    void setBook_name(String book_name){
        this.book_name = book_name;
    }
    void setISBN(int ISBN){
        this.ISBN = ISBN;
    }
    void setAuthor(String author){
        this.author = author;
    }
    void setPublisher(String publisher){
        this.publisher = publisher;
    }
    void setDate(String date){
        this.date = date;
    }

    // get methods
    String getBook_name(){
        return this.book_name;
    }
    int getISBN(){
        return this.ISBN;
    }
    String getAuthor(){
        return this.author;
    }
    String getPublisher(){
        return this.publisher;
    }
    String getDate(){
        return this.date;
    }



}
