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
class StringNode extends ListNode {
    String value;
    boolean isLessThan (ListNode x) { return false; }
    boolean isEqualTo (ListNode x) { return false; }
}

//Unterklasse PersonNode:
class PersonNode extends ListNode {
    Person value;
    boolean isLessThan (ListNode x) { return false; }
    boolean isEqualTo (ListNode x) { return false; }
}

//Klasse SortedList:
class SortedList {
    ListNode first;

    void insert (ListNode node) {
        ListNode p = first;
        ListNode prev = null;
        while (p != null && p.isLessThan(node)) {
            prev = p;
            p = p.next;
        }
        if (prev == null) {
            node.next = first;
            first = node;
        } else {
            node.next = p;
            prev.next = node;
        }
    }

    void delete (ListNode node) {
        ListNode p = first;
        ListNode prev = null;
        while (p != null && !p.isEqualTo(node)) {
            prev = p;
            p = p.next;
        }
        if (p != null) {
            if (prev == null) {
                first = p.next;
            } else {
                prev.next = p.next;
            }
        }
    }

    void print () {
        ListNode p = first;
        while (p != null) {
            System.out.println(p);
            p = p.next;
        }
    }
}

//Testprogramm:
class Solution_3 {
    public static void main(String[] args) {
        SortedList list = new SortedList();
        list.insert(new StringNode("Hello"));
        list.insert(new StringNode("World"));
        list.insert(new PersonNode(new Person("Hans", "Muster")));
        list.insert(new PersonNode(new Person("Max", "Mustermann")));
        list.print();
        list.delete(new PersonNode(new Person("Hans", "Muster")));
        list.print();
    }
}

