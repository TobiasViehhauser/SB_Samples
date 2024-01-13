// H. Moessenboeck: Sprechen Sie Java? -- Kapitel 12, Aufgabe 5
// "Bibliotheksverwaltung"

//------------------------------------------------------
// A book in the library
//------------------------------------------------------
class Book {
    String author;
    String title;
    String ISBN;
    String publisher;
    Book next;
}

//------------------------------------------------------
// Library as a sorted list of books
//------------------------------------------------------
class Library {
    Book list = null;
    Book cur;  // current element of iteration

    void insert(Book b) {
        Book p = list, last = null;
        while (p != null && b.ISBN.compareTo(p.ISBN) > 0) {
            last = p; p = p.next;
        }
        if (p != null && b.ISBN.equals(p.ISBN)) // already in list; replace it
            b.next = p.next;
        else  // insert it before p
            b.next = p;
        if (p == list) list = b; else last.next = b;
    }

    void remove(String ISBN) {
        Book p = list, last = null;
        while (p != null && ISBN.compareTo(p.ISBN) > 0) {
            last = p; p = p.next;
        }
        if (p != null && ISBN.equals(p.ISBN))
            if (p == list) list = p.next; else last.next = p.next;
    }

    Book lookup(String ISBN) {
        Book p = list;
        while (p != null && ISBN.compareTo(p.ISBN) > 0) p = p.next;
        if (p != null & ISBN.equals(p.ISBN)) return p; else return null;
    }

    void resetIteration() {
        cur = list;
    }

    Book nextBook() {
        if (cur == null) return null;
        else {
            Book b = cur; cur = cur.next;
            return b;
        }
    }
}

//------------------------------------------------------
// Test program
//------------------------------------------------------
public class A5 {

    static Book readBook() {
        Book b = new Book();
        b.author = In.readString();
        if (b.author.equals("END")) return null;
        b.title = In.readString();
        b.ISBN = In.readWord();
        b.publisher = In.readString();
        return b;
    }

    static void print(Book b) {
        if (b != null)
            Out.print(b.author + ": " + b.title + ", " + b.publisher + ", " + b.ISBN);
        else
            Out.print("null");
    }

    public static void main(String args[]) {
        In.open("input.txt");
        //--- fill the library
        Library lib = new Library();
        Book b = readBook();
        while (b != null) {
            lib.insert(b);
            b = readBook();
        }
        In.close();

        //--- process commands from keyboard
        String cmd = In.readWord();
        String ISBN;
        while (In.done()) {
            if (cmd.equals("remove")) {
                ISBN = In.readWord();
                Out.println(); Out.println("remove " + ISBN);
                lib.remove(ISBN);
            } else if (cmd.equals("lookup")) {
                ISBN = In.readWord();
                b = lib.lookup(ISBN);
                Out.println(); Out.print("lookup " + ISBN + " => ");
                print(b); Out.println();
            } else if (cmd.equals("list")) {
                Out.println(); Out.println("List of books:");
                lib.resetIteration();
                b = lib.nextBook();
                while (b != null) {
                    print(b); Out.println();
                    b = lib.nextBook();
                }
            } else if (cmd.equals("quit")) {
                break;
            }
            cmd = In.readWord();
        }
    }
}

/*
Sample input from file:
----------------------
"Knuth" "The Art of Computer Programming" 3-86754-556-2 "Addison-Wesley"
"Aho" "Data Structures and Algorithms" 0-201-00023-7 "Addison-Wesely"
"Sedgewick" "Algorithms" 0-201-06673-4 "Addison-Wesley"
"Wirth" "Algorithmen und Datenstrukturen mit Modula-2" 3-519-02260-5 "Teubner"
"END"

Sample input from keyboard:
--------------------------
list
lookup 0-201-06673-4
remove 0-201-06673-4
remove 0-201-06673-5
list
*/