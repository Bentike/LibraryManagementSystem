import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList <Book> storyBooks = new ArrayList<Book>();
        addBook(storyBooks, "Charles Dickens", "Oliver Twist", 427);
        addBook(storyBooks, "Bram Stoker", "Dracular", 1500);
        addBook(storyBooks, "Leo Tolstoy", "War and Peace", 1386);
        addBook(storyBooks, "Anna Sewell", "Black Beauty", 64);
        getAllBooks(storyBooks);
    }

    // This method Prints all All the Books available in a Library
    // I accepts an ArrayList<Book> argument
    public static void getAllBooks(ArrayList<Book> library){
        for(Book book : library){
            System.out.println("***************************");
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Number of Pages: " + book.getPages());
        }
    }

    // This method add a new book to the library, it takes 4 parameters,
    // the name of the library you want to add the book.
    // the name of the author
    // the title of the book
    // the number of pages of the book
    public static ArrayList<Book> addBook(ArrayList<Book> library, String author, String title, int pages){
         Book newBook = new Book(author, title, pages);
         library.add(newBook);
         return library;
    }

    // This method deletes a book from the library, it takes 2 parameters,
    // First is the name of the library you want to remove the book from,
    // Second is the title of the book you want to delete.
    public static ArrayList<Book> deleteBook(ArrayList<Book> library, String title){
        for(int i = 0; i < library.size(); i++){
            if(library.get(i).getTitle().equals(title)){
                library.remove(i);
            }
        }
        return library;
    }

    // This method updates a book, It takes 2 parameters,
    // First is the name the Library containing the book you want to update
    // Second is the title of the book you want to update
    public static Book updateBook(ArrayList<Book> library, String title){
        //Firstly Find book by the title
        Book bookToUpdate = new Book("", "", 0);
        for(int i = 0; i < library.size(); i++){
            if(library.get(i).getTitle().equals(title)){
               bookToUpdate = library.get(i);
            }
        }

        // Get input from user to update book
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new author");
        String newAuthor = scanner.nextLine();
        System.out.println("Enter new title");
        String newTitle = scanner.nextLine();
        System.out.println("Enter new pages");
        int newPages = scanner.nextInt();

        // update book and return book
        bookToUpdate.setAuthor(newAuthor);
        bookToUpdate.setTitle(newTitle);
        bookToUpdate.setPages(newPages);
        return bookToUpdate;
    }


    static class Book{
        String author;
        String title;
        int pages;

        public String getAuthor(){
           return author;
        };

        public String getTitle(){
            return title;
        };

        public int getPages(){
            return pages;
        };

        public void setAuthor(String author){
            this.author = author;
        }

        public void setTitle(String title){
            this.title = title;
        }

        public void setPages(int pages){
            this.pages = pages;
        }

        Book(String author, String title, int pages){
            this.author = author;
            this.title = title;
            this.pages = pages;
        }
    }
}