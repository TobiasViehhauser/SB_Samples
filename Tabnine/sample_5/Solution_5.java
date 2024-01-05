import java.util.ArrayList;

/**
 * Sample_5
 * from Sprechen Sie Java? by Hanspeter Mössenböck
 * example 16.2 on page 219
 */

/*
Rekursive Verwaltung von Listen. Implementieren Sie rekursive Methoden
zum Einfügen, Löschen und Suchen von Werten in einer dynamisch verketteten Liste
 */


//1 Versuch
public class ListManager {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void delete(int value) {
        if (head == null) {
            return;
        } else if (head.value == value) {
            head = head.next;
        } else {
            Node current = head;
            while (current.next != null) {
                if (current.next.value == value) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }
    }

    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListManager list = new ListManager();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        System.out.println("List before deleting 30: " + list);
        list.delete(30);
        System.out.println("List after deleting 30: " + list);
        System.out.println("30 is in the list: " + list.search(30));
    }
}