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

// Methode search(isbn)

// Methode delete(isbn)

// Methode iterate

// Klasse Library

// Methode addBook

// Testprogramm

// Lösung:
import java.util.*;

class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString() {
        return isbn + " " + title + " " + author + " " + year;
    }

    public String getIsbn() {
        return isbn;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void iterate() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void search(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                System.out.println(b);
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void delete(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                books.remove(b);
                return;
            }
        }
        System.out.println("Book not found");
    }
}

public class Solution_1 {
    public static void main(String[] args) {
        Library l = new Library();
        l.addBook(new Book("978-3-8362-7272-8", "Java ist auch eine Insel", "Christian Ullenboom", 2017));
        l.addBook(new Book("978-3-8362-5687-9", "Java 8 - Die Neuerungen", "Michael Inden", 2014));
        l.addBook(new Book("978-3-8362-7272-8", "Java ist auch eine Insel", "Christian Ullenboom", 2017));
        l.addBook(new Book("978-3-8362-5687-9", "Java 8 - Die Neuerungen", "Michael Inden", 2014));
        l.iterate();
        l.search("978-3-8362-7272-8");
        l.search("978-3-8362-5687-9");