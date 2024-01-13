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

// Klasse Library
class library {
        ArrayList<Book> books;

        library() {
                books = new ArrayList<Book>();
        }

        // Methode addBook
        addBook(Book book) {
                books.add(book);
        }

        // Methode search
        String search(String isbn) {
                for (Book book : books) {
                        if (book.isbn.equals(isbn)) {
                                return book.toString();
                        }
                }
                return "Book not found";
        }

        // Methode delete
        void delete(String isbn) {
                for (Book book : books) {
                        if (book.isbn.equals(isbn)) {
                                books.remove(book);
                                return;
                        }
                }
        }

        // Methode iterate
        void iterate() {
                for (Book book : books) {
                        System.out.println(book);
                }
        }
}

// Testprogramm
class Test {
        public static void main(String[] args) {
                library library = new library();
                library.addBook(new Book("Hans", "Java", "123", "Verlag"));
                library.addBook(new Book("Peter", "C++", "456", "Verlag"));
                library.addBook(new Book("Max", "Python", "789", "Verlag"));
                System.out.println(library.search("123"));
                library.delete("123");
                library.iterate();
        }
}