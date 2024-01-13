/**
 * Solution for
 *
 * Sample_2
 * from Sprechen Sie Java? by Hanspeter Mössenböck
 * example 12.7 on page 180
 */

// Gegeben Klasse:
class Node {
    int val;
    Node next;
}

        Node p, current, previous, root;
boolean exit;

// Verbessere oder korrigiere folgende Code-Elemente:
// 1.
p = root;
        while (p != null) {
        System.out.println(p.val);
p = p.next;
        }

// 2.
p = new Node(0);
p = current;

// 3.
        if (current.val == val) {
exit = true;
        } else {
exit = false;
        }
        while (p != null && p.val != val) {
// Code
p = p.next;
        }
                if (p != null && p.val == val) {
        // Code
        }

// 4.
        if (current.next == null) {
previous.next = null;
current.next = root;
root = current;
        } else {
previous.next = current.next;
current.next = root;
root = current;
        }

// 5.
exit = false;
        while (p != null && !exit) {
        if (p.val == val) {
exit = true;
        } else {
p = p.next;
        }
                }

// 6.
p = root;
root = current;
root.next = p;