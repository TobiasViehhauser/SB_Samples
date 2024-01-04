import java.util.ArrayList;

/**
 * Solution for
 *
 * Sample_1
 * from Sprechen Sie Java? by Hanspeter Mössenböck
 * example 12.5 on page 179
 */

/*
Bibliotheksverwaltung. Implementieren Sie eine Bibliotheksverwaltung mit
folgender Funktionalität:
 */

// Klasse Book

// Methode search

// Methode delete

// Methode iterate

// Klasse Library

// Methode addBook

// Testprogramm

//Lösung:

    //2 Versuche
//class Book
class Book {
    //Autor, Titel, ISBN NUmmer, Verlag
    String author;
    String title;
    String isbn;
    String publisher;

    Book(String author, String title, String isbn, String publisher) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public String toString() {
        return author + " " + title + " " + isbn + " " + publisher;
    }

    }

}

//2 Versuche
//class Library with arraylist books
class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<Book>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    //2 Verusche und else method musste extra gemacht werden
    //method for searching with isbn return print
    void search(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                System.out.println(book);
            }
        }
        //else method
        System.out.println("Book not found");
    }

    //1 Versuch
    //method for deleting book with isbn
    void delete(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                books.remove(book);
                System.out.println("Book deleted");
                return;
            }
        }
        System.out.println("Book not found");
    }

    //1 Versuch und auch automatisch vorgeschlagen
    //method for iterating over books
    void iterate() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

}

//1 Versuch automatisch vorgeschlagen
//class for testing
class Test {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Hans", "Java", "123", "Verlag"));
        library.addBook(new Book("Peter", "C++", "456", "Verlag"));
        library.addBook(new Book("Max", "Python", "789", "Verlag"));
        library.search("123");
        library.delete("123");
        library.iterate();
    }
}

