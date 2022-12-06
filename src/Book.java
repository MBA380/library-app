public class Book {
    private String book_name;
    private int ISBN;
    private String author;
    private String publisher;
    private String date;

    // overrides toString
    public String toString(){
        return "Book name = " + this.book_name + " | ISBN = " + this.ISBN + " | Author = " + this.author + " | Publisher = " + this.publisher + " | Date published = " + this.date;
    }

    // Default parameter that returns a dummy book
    Book(){
        this("Dummy Book", 101, "John Doe", "John Publishing", "May 13 2004");
    }
    Book(String book_name, int ISBN, String author, String publisher, String date){
        this.book_name = book_name;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
    }

    // setter methods
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

    // getter methods
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
