/**
 * Solution for
 *
 * Sample_3
 * from Sprechen Sie Java? by Hanspeter Mössenböck
 * example 13.4 on page 197
 */


//Gegebene Klasse ListNode:
class ListNode {
    ListNode next;
    boolean isLessThan (Listnode x) { return false; }
    boolean isEqualTo (ListNode x) { return false; }
}

//Unterklasse StringNode:

//class Stringnode
//erster Versuch
class StringNode extends ListNode {
    StringNode next;
    String data;
    boolean isLessThan (ListNode x) { return false; }
    boolean isEqualTo (ListNode x) { return false; }
}

//Unterklasse PersonNode:

//class PersonNode
//erster Versuch
class PersonNode extends ListNode {
    PersonNode next;
    Person data;
    boolean isLessThan (ListNode x) { return false; }
    boolean isEqualTo (ListNode x) { return false; }
}

//Klasse SortedList:

//class SortedList
    class SortedList {

    //erster Versuch
    //method insert new Node
    void insert(ListNode x) {
        ListNode p = head;
        ListNode q = null;
        while (p != null && p.isLessThan(x)) {
            q = p;
            p = p.next;
        }
        if (q == null) {
            x.next = head;
            head = x;
        } else {
            q.next = x;
            x.next = p;
        }
    }

    //2 Versuche
    //method delete existing Node
    void delete(ListNode x) {
        ListNode p = head;
        ListNode q = null;
        while (p != null && !p.isEqualTo(x)) {
            q = p;
            p = p.next;
        }
        if (q == null) {
            head = head.next;
        } else {
            q.next = p.next;
        }
        x.next = null;
    }

    //erster Versuch
    //Mehod for printing the list
    void print() {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }

    }
}

//Testprogramm:

    //erster Versuch sofort
//Class for Testing
class Test {
    public static void main (String[] args) {
        SortedList list = new SortedList();
        list.insert(new StringNode());
        list.insert(new PersonNode());
        list.print();
    }
}

