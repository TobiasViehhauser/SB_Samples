/**
 * Solution for
 *
 * Sample_5
 * from Sprechen Sie Java? by Hanspeter Mössenböck
 * example 16.2 on page 219
 */

/*
Rekursive Verwaltung von Listen. Implementieren Sie rekursive Methoden
zum Einfügen, Löschen und Suchen von Werten in einer dynamisch verketteten Liste
 */

//Rekursive Verwaltung von Listen. Implementieren Sie rekursive Methoden:

//erster Versuch
//create a class for a Node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

//2. Versuch aber dafür alle Methoden automatisch
//Class for a linked List
class LinkedList {
    Node head;

    //insert a new node at the beginning of the list
    void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //delete a node from the list recursively
    void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        head.next = delete(head.next, data);
    }

    //search for a node in the list recursively
    Node search(Node head, int data) {
        if (head == null) {
            return null;
        }
        if (head.data == data) {
            return head;
        }
        return search(head.next, data);


}

//Testprogramm
    //erster Versuch
//Test for all methods
public class Solution {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.delete(2);
        System.out.println(list.search(3));
    }
}
