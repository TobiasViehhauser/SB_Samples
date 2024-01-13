// H. Moessenboeck: Sprechen Sie Java? -- Kapitel 16, Aufgabe 2
// "Rekursive Verwaltung von Listen"

class Node {
    int val;
    Node next;
    Node(int x) { val = x; }
}

class List {
    Node first = null;

    private Node ins(Node head, int x) {
        if (head == null) return new Node(x);
        else {
            head.next = ins(head.next, x);
            return head;
        }
    }

    private Node del(Node head, int x) {
        if (head == null) return null;
        else if (head.val == x) return head.next;
        else {
            head.next = del(head.next, x);
            return head;
        }
    }

    private Node find(Node head, int x) {
        if (head == null) return null;
        else if (head.val == x) return head;
        else return find(head.next, x);
    }

    void insert(int x) {
        first = ins(first, x);
    }

    void delete(int x) {
        first = del(first, x);
    }

    Node lookup(int x) {
        return find(first, x);
    }

    void print() {
        for (Node p = first; p != null; p = p.next) Out.print(p.val + " ");
        Out.println();
    }
}

public class A2 {

    public static void main(String args[]) {
        List list = new List();
        list.insert(7);
        list.insert(5);
        list.insert(4);
        list.insert(2);
        list.print();

        list.delete(4);
        list.delete(3);
        list.print();

        Node x = list.lookup(5);
        Out.print("Wert 5 ");
        if (x == null) Out.println("nicht gefunden"); else Out.println("gefunden");
        x = list.lookup(4);
        Out.print("Wert 4 ");
        if (x == null) Out.println("nicht gefunden"); else Out.println("gefunden");
    }
}