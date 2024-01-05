/**
 * Solution for
 *
 * Sample_2
 * from Sprechen Sie Java? by Hanspeter Mössenböck
 * example 12.7 on page 180
 */

//Gegebene Klasse:
class Node { int val; Node next; }
        Node p, current, previous, root;
boolean exit;

//Verbessere oder korrigiere folgende Code Elemente:
// 1.
p = root; while (p != null) p = p.next;

//simplify code: p = root; while (p != null) p = p.next;
        while (p != null) p = p.next;

// 2.
p = new Node(0); p = current;

//simplify code: p = new Node(0); p = current;
        while (p != null) p = p.next;

        p = root; while (p != null && p.val != val) { …; p = p.next; }

// 3.
if (current.val == val) exit = true; else exit = false;

//simplify code: if (current.val == val) exit = true; else exit = false;
        if (current.val == val) exit = true; else exit = false;

        p = root; while (p != null && ! exit) {
        if (p.val == val) exit = true;
        else p = p.next;
}

// 4.
while (p != null && p.val != val) { …; p = p.next; }
if (p != null && p.val == val)

//simplify code: while (p != null && p.val != val) { …; p = p.next; } if (p != null && p.val == val)
        while (p != null && p.val != val) { …; p = p.next; }


// 5.
if (current.next == null) {
previous.next = null; current.next = root; root = current;
} else {
previous.next = current.next; current.next = root; root = current;
}

//simplify code:if (current.next == null) { previous.next = null; current.next = root; root = current; } else { previous.next = current.next; current.next = root; root = current; }
        if (current.next == null) { previous.next = null; current.next = root; root = current; } else { previous.next = current.next; current.next = root; root = current; }

// 6.
exit = false;
        while (p != null && ! exit) {
        if (p.val == val) exit = true;
        else p = p.next;
}

//simplify code:exit = false;while (p != null && ! exit) {if (p.val == val) exit = true;else p = p.next; }
        if (p != null && p.val == val) exit = true; else exit = false;

// 7.
p = root; root = current; root.next = p

//simplify code p = root; root = current; root.next = p
        while (p != null) p = p.next;
        root.next = p;
}

