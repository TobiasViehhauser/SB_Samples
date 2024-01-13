// H. Moessenboeck: Sprechen Sie Java? -- Kapitel 13, Aufgabe 4
// "Generische sortierte Liste"

//---------------------------------------------------
// class ListNode (should be an abstract class)
//---------------------------------------------------
class ListNode {
    ListNode next;
    boolean isLessThan(ListNode x) { return false; }
    boolean isEqualTo(ListNode x) { return false; }
}

//---------------------------------------------------
// class SortedList
//---------------------------------------------------
class SortedList {
    ListNode first = null;

    void insert(ListNode x) {
        ListNode p = first, last = null;
        while (p != null && p.isLessThan(x)) {
            last = p; p = p.next;
        }
        if (p == null || x.isLessThan(p))
            x.next = p;
        else // x.isEqualTo(p)
            x.next = p.next;
        if (p == first) first = x; else last.next = x;
    }

    void delete(ListNode x) {
        ListNode p = first, last = null;
        while (p != null && p.isLessThan(x)) {
            last = p; p = p.next;
        }
        if (p != null && p.isEqualTo(x)) {
            x.next = p.next;
            if (p == first) first = p.next; else last.next = p.next;
        }
    }

    void print() {
        for (ListNode p = first; p != null; p = p.next)
            Out.println(p.toString());
    }
}


//---------------------------------------------------
// class StringNode
//---------------------------------------------------
class StringNode extends ListNode {
    String s;

    StringNode(String s) { this.s = s; }

    boolean isLessThan(ListNode x) {
        StringNode sn = (StringNode)x;
        return s.compareTo(sn.s) < 0;
    }

    boolean isEqualTo(ListNode x) {
        StringNode sn = (StringNode)x;
        return s.compareTo(sn.s) == 0;
    }

    public String toString() {
        return s;
    }
}

//---------------------------------------------------
// class PersonNode
//---------------------------------------------------
class PersonNode extends ListNode {
    String name;
    String address;
    int id;

    PersonNode(String name, String address, int id) {
        this.name = name; this.address = address; this.id = id;
    }

    boolean isLessThan(ListNode x) {
        PersonNode pn = (PersonNode)x;
        return name.compareTo(pn.name) < 0;
    }

    boolean isEqualTo(ListNode x) {
        PersonNode pn = (PersonNode)x;
        return name.compareTo(pn.name) == 0;
    }

    public String toString() {
        return name + ", " + address + ", id = " + id;
    }
}

//---------------------------------------------------
// Test program
//---------------------------------------------------
public class A4 {

    public static void main(String args[]) {
        SortedList stringList = new SortedList();
        stringList.insert(new StringNode("Hello"));
        stringList.insert(new StringNode("String"));
        stringList.insert(new StringNode("List"));
        stringList.insert(new StringNode("Test"));
        stringList.print();
        Out.println();
        stringList.delete(new StringNode("Test"));
        stringList.print();
        Out.println();

        SortedList personList = new SortedList();
        personList.insert(new PersonNode("Maier", "Wiesenweg 2", 100));
        personList.insert(new PersonNode("Huber", "Holzweg 5", 50));
        personList.insert(new PersonNode("Zeller", "Waldweg 13", 200));
        personList.insert(new PersonNode("Gasser", "Krumme Gasse 3", 150));
        personList.print();
        Out.println();
        personList.delete(new PersonNode("Huber", "", 0));
        personList.print();
        Out.println();
    }
}