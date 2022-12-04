import java.io.*;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class ConsoleLibApp {

    String filedir;
    int input1;
    int input2;
    String input3;
    String input4;
    int input5;
    String input6;
    String input7;
    String input8;
    String input9;
    String input10;
    String input11;
    Scanner inp = new Scanner(System.in);
    ArrayList<Book> bookArrayList = new ArrayList<>();
    File booklist;

    // Part B Task c.1; Method to read a file of books into dynamic array
    public void scannerReadFile() throws Exception {
        booklist = new File(filedir);
        Scanner bookscanner = new Scanner(booklist);
        // Scans the text file and adds all lines into booksarray
        while (bookscanner.hasNext()) {
            String title = bookscanner.nextLine();
            String SISBN = bookscanner.nextLine();
            String author = bookscanner.nextLine();
            String publisher = bookscanner.nextLine();
            String date = bookscanner.nextLine();
            bookscanner.nextLine();
            Book newbook = new Book(title, Integer.parseInt(SISBN), author, publisher, date);
            bookArrayList.add(newbook);
        }
    }

    // Part B Task c.3; displays books published after some specified year
    ArrayList<Book> publishedafterx(int b){
        ArrayList<Book> temparray = new ArrayList<>();
        for(Book all : bookArrayList){
            String[] date = all.getDate().split(" ");
            int year = Integer.parseInt(date[2]);
            if(year >= b){
                temparray.add(all);
            }
        }
        return temparray;
    }

    // Part B task c.4; returns book given author name, if not found it returns dummy book
    ArrayList<Book> authorfinder(String name){
        ArrayList<Book> temparray = new ArrayList<>();
        for(Book all : bookArrayList){
            if(all.getAuthor().equals(name)){
                temparray.add(all);
            }
        }
        if(temparray.isEmpty()){
            ArrayList<Book> empty = new ArrayList<>();
            Book empty1 = new Book();
            empty.add(empty1);
            return empty;
        }
        return temparray;
    }

    // Part B task c.5; Add a new book to the list
    void addbook(String book_name, int ISBN, String author, String publisher, String date) {
        Book newbook = new Book(book_name, ISBN, author, publisher, date);
        bookArrayList.add(newbook);
    }

    public void firstMenu() throws Exception {
        System.out.println("**************** Welcome to the Library ****************");
        System.out.println("=====================================================");
        System.out.println("  Please enter the directory for the file of books");
        System.out.println("======================================================");
        // Filters input if user gives in backward slashes
        // Also catches FileNotFoundException and forces user to enter a valid file
        while(true) {
            try {
                String input = inp.nextLine();
                filedir = input.replaceAll("\\\\", "/");
                scannerReadFile();
                break;
            } catch (FileNotFoundException file) {
                System.out.println("Please enter a valid file");
            }
        }
    }

    public void secondMenu(){
        System.out.println("************* Welcome to the Library **************");
        System.out.println("======================================================");
        System.out.println("           1. Display the list of books");
        System.out.println("           2. Find books published after x year");
        System.out.println("           3. Find books published by x author");
        System.out.println("           4. Add a new book to the list");
        System.out.println("           5. Save and extract all books");
        System.out.println("           6. Exit                      ");
        System.out.println("======================================================");
        System.out.println("           Please select your choice");
    }

    public void options() throws IOException {
        secondMenu();
        while(true){
            input1 = inp.nextInt();
            switch(input1){
                case 1 : // Display list of books
                    for (Book a : bookArrayList) {
                        System.out.println(a);
                    }
                    break;
                case 2: // Find books published after x year
                    System.out.println("Please enter the year you would like to search after");
                    while(true) {
                        try {
                            input2 = inp.nextInt();
                            for (Book a : publishedafterx(input2)) {
                                System.out.println(a);
                            }
                            break;
                        } catch (InputMismatchException excep) {
                            System.out.println("Please enter a valid year");
                            inp.next();
                        }
                    }
                    break;
                case 3: // Find books published by x author

                    inp.nextLine();

                    System.out.println("Please enter the author whose books you would like to find");
                    input3 = inp.nextLine();
                    for(Book all : authorfinder(input3)){
                        System.out.println(all);
                    }
                    break;
                case 4: // Add a new book to the list

                    while(true) {
                        Scanner newinp = new Scanner(System.in);
                        try {
                            System.out.println("Please enter the book name");
                            input4 = newinp.nextLine();
                            System.out.println("Please enter the book ISBN");
                            String ISBNinp = newinp.nextLine();
                            input5 = Integer.parseInt(ISBNinp);
                            System.out.println("Please enter the Authors first and last name");
                            input6 = newinp.nextLine();
                            System.out.println("Please enter the book publisher");
                            input7 = newinp.nextLine();
                            System.out.println("Please enter the published date in the following format:");
                            System.out.println("                  ''Jun 14 2010''");
                            input8 = newinp.nextLine();
                            addbook(input4, input5, input6, input7, input8);
                            break;
                        }
                        catch (NumberFormatException misinput){
                            System.out.println("Please enter a valid integer, try again");
                            System.out.println();
                        }
                    }

                    System.out.println("Would you like to save and extract the new file (Y/N) ?");
                    input11 = inp.next();
                    if(input11.equalsIgnoreCase("N")){
                        break;
                    }
                    else if(input11.equalsIgnoreCase("Y")){
                    }
                    else{
                        break;
                    }
                case 5: // Part B task c.6; File writing method to write to a file
                    System.out.println("======================================================");
                    System.out.println("Please enter the directory where you will like to save along with the file name");
                    System.out.println("Note: Default directory is in the folder your .jar or .java files are in");
                    System.out.println("e.g. C:\\Users\\Mahad\\Downloads\\Filename.txt");
                    System.out.println("======================================================");

                    // Filters input if user gives in backward slashes
                    inp.nextLine();
                    String input10 = inp.nextLine();
                    input9 = input10.replaceAll("\\\\", "/");
                    FileWriter writer = new FileWriter(input9);
                    for(Book allbooks : bookArrayList){
                        writer.write(allbooks.getBook_name() + "\n" + allbooks.getISBN() + "\n" + allbooks.getAuthor()
                                + "\n" + allbooks.getPublisher() + "\n" + allbooks.getDate() + "\n");
                        writer.write("\n");
                    }
                    writer.close();
                    break;
                case 6:
                    break;
            }
            finalrun();
        }
    }

    void finalrun() throws IOException{
        System.out.println();
        System.out.print("Do you wish to exit (Y/N) : ");
        input10 = inp.next();
        if(input10.equalsIgnoreCase("N")){
            options();
        }
        else if(input10.equalsIgnoreCase("Y")){
            System.exit(1);
        }
        else{
            System.out.println("Invalid Choice");
            finalrun();
        }
    }
}
