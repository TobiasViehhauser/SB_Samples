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
//Einfügen, Löschen und Suchen von Werten in einer dynamisch verketteten Liste

//Knoten Klasse
class Node {
    int data;
    Node next;

    //Konstruktor
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

//Liste Klasse
class List {
    Node head;

    //Konstruktor
    List(){
        this.head = null;
    }

    //Einfügen
    public void insert(int data){
        head = insert(head, data);
    }

    //Einfügen
    public Node insert(Node node, int data){
        if(node == null){
            node = new Node(data);
        }
        else {
            node.next = insert(node.next, data);
        }
        return node;
    }

    //Löschen
    public void delete(int data){
        head = delete(head, data);
    }

    //Löschen
    public Node delete(Node node, int data){
        if(node == null){
            return null;
        }
        else if(node.data == data){
            return node.next;
        }
        else {
            node.next = delete(node.next, data);
            return node;
        }
    }

    //Suchen
    public boolean search(int data){
        return search(head, data);
    }

    //Suchen
    public boolean search(Node node, int data){
        if(node == null){
            return false;
        }
        else if(node.data == data){
            return true;
        }
        else {
            return search(node.next, data);
        }
    }
}

//Testprogramm
public class Solution_5 {
    public static void main(String[] args){
        List list = new List();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        System.out.println("Liste nach dem Einfügen von 1, 2, 3, 4, 5:");
        System.out.println(list.search(4));
        System.out.println(list.search(6));
        list.delete(4);
        System.out.println("Liste nach dem Löschen von 4:");
        System.out.println(list.search(4));
    }
}

//Ausgabe:
//Liste nach dem Einfügen von 1, 2, 3, 4, 5

//Einfügen

//Löschen

//Suchen

//Testprogramm
