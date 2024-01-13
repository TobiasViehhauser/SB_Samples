// H. Moessenboeck: Sprechen Sie Java? -- Kapitel 12, Aufgabe 5
// "Bibliotheksverwaltung"

p = null;

p = current;

exit = current.val == val;

while (p != null && p.val != val) {…; p = p.next; }
// p == null || p.val == val
if (p!= null) ... // p.val == val

previous.next = current.next; current.next = root; root = current;

while (p != null && p.val != val) p = p.next;

current.next = root; root = current;