/**
 * Solution for
 *
 * Sample_3
 * from Sprechen Sie Java? by Hanspeter Mössenböck
 * example 13.4 on page 197
 */

//2 Versuch aber ganzes File wurde generiert
//Gegebene Klasse ListNode:
class ListNode {
    ListNode next;
    boolean isLessThan (Listnode x) { return false; }
    boolean isEqualTo (ListNode x) { return false; }
}


// Gegeben Klasse:
class ListNode {
    ListNode next;
    boolean isLessThan(ListNode x) {
        return false;
    }

    boolean isEqualTo(ListNode x) {
        return false;
    }
}

// Unterklasse: StringNode
class StringNode extends ListNode {
    String value;

    boolean isLessThan(StringNode x) {
        return value.compareTo(x.value) < 0;
    }

    boolean isEqualTo(StringNode x) {
        return value.compareTo(x.value) == 0;
    }
}

// Unterklasse: PersonNode
class PersonNode extends ListNode {
    String name;
    int age;

    boolean isLessThan(PersonNode x) {
        return name.compareTo(x.name) < 0 || (name.compareTo(x.name) == 0 && age < x.age);
    }

    boolean isEqualTo(PersonNode x) {
        return name.compareTo(x.name) == 0 && age == x.age;
    }
}

// Klasse: SortedList
class SortedList {
    ListNode head;

    void add(ListNode node) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null && node.isLessThan(current)) {
            previous = current;
            current = current.next;
        }
        node.next = current;
        if (previous == null) {
            head = node;
        } else {
            previous.next = node;
        }
    }
}

// Testprogramm:
public class Main {
    public static void main(String[] args) {
        SortedList list = new SortedList();

        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();

        StringNode node6 = new StringNode();
        node6.value = "Apple";
        PersonNode node7 = new PersonNode();
        node7.name = "John";
        node7.age = 25;

        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        list.add(node7);

        ListNode current = list.head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}

//Klasse SortedList:

//Testprogramm:

