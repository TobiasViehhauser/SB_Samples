/**
 * Solution for
 *
 * Sample_7
 * from Aufgabensammlung zu Algorithmen und Datenstrukturen from Peter Widmayer and Thomas Ottmann
 * example 53 on page 20
 */


/*
Ein Stack (Stapel) ist ein abstrakter Datentyp, den man mit einem Stapel von Tellern vergleichen kann.
Bei einem Tellerstapel kann man entweder einen weiteren Teller oben drauflegen oder den obersten Teller
wegnehmen. Diese Strategie wird als LIFO (last in first out) bezeichnet.
Ein Stack beschränkter maximaler Grösse bietet folgende Operationen an:
init(S): Initialisiert S als leeren Stack.
push(S,x): Legt das Objekt x “zuoberst” auf den Stack S. Falls der Stack S bereits voll ist (d.h. die maximale Grösse erreicht hat), gibt es eine Fehlermeldung.
top(S): Liefert das “oberste” Objekt x des Stacks S. Falls der Stack S leer ist, gibt es eine Fehlermeldung.
pop(S): Liefert das “oberste” Objekt x des Stacks S und entfernt es vom Stack. Falls der Stack S leer ist,
gibt es eine Fehlermeldung.
empty(S): Liefert T RUE, falls der Stack S leer ist, andernfalls F ALSE.
full(S): Liefert T RUE, falls der Stack S voll ist, andernfalls F ALSE.
1. Schreibe ein Programm, das einen Stack und seine Operationen zur Verfügung stellt. Der Stack soll
maximal 451 Elemente enthalten. Die Elemente sind ganze Zahlen.
2. Verwende den Stack aus Aufgabenteil a, um eine Zahlenfolge, die der Benutzer bzw. die Benutzerin
eingibt, umzukehren.
 */

//Klasse Stack
class Stack {
    // Attribute
    int[] stack;
    int top;
    int max;

    //Konstruktor
    Stack(int max) {
        this.stack = new int[max];
        this.top = -1;
        this.max = max;
    }

    // Methode init(S)
    void init() {
        this.top = -1;
    }

    // Methode push(S,x)
    void push(int x) {
        if (this.top < this.max) {
            this.top++;
            this.stack[this.top] = x;
        } else {
            System.out.println("Stack is full");
        }
    }

    // Methode top(S)
    int top() {
        if (this.top >= 0) {
            return this.stack[this.top];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // Methode pop(S)
    int pop() {
        if (this.top >= 0) {
            int x = this.stack[this.top];
            this.top--;
            return x;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // Methode empty(S)
    boolean empty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    // Methode full(S)
    boolean full() {
        if (this.top == this.max - 1) {
            return true;
        } else {
            return false;
        }
    }

    // Methode main
    public static void main(String[] args) {
        // Erstelle Stack mit maximal 451 Elementen
        Stack stack = new Stack(451);
        // Initialisiere Stack
        stack.init();
        // Fülle Stack mit 451 Elementen
        for (int i = 0; i < 451; i++) {
            stack.push(i);
        }
        // Leere Stack
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    // Methode reverse
    static Stack reverse(Stack s) {
        // Erstelle neuen Stack mit gleicher maximaler Grösse
        Stack newStack = new Stack(s.max);
        // Initialisiere neuen Stack
        newStack.init();
        // Fülle neuen Stack mit Elementen aus altem Stack
