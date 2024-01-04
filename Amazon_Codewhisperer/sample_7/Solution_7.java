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



// Klasse Stack

class Stack {

    //2 Versuche
    //attributes for a stack
    private int[] stack;
    private int top;

    //constructor
    Stack(int size) {
        stack = new int[size];
        top = -1;
    }

    // Methode init(s)
    void init(Stack s) {
        s.top = -1;
    }


    //Methode push automatisch generiert
    void push(Stack s, int x) {
        if (s.top == stack.length - 1) {
            System.out.println("Stack is full");
        } else {
            s.stack[++s.top] = x;
        }
    }

    //1 Versuch
    // Methode top(S)
    int top(Stack s) {
        if (s.top == -1) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return s.stack[s.top];
        }
    }

    //1. Versuch
    //Methode Pop(s)
    int pop(Stack s) {
        if (s.top == -1) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return s.stack[s.top--];
        }
    }

    //1 Versuch
    //Method empty(S) returns true if the stack is empty
    boolean empty(Stack s) {
        if (s.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    //Method full(s) returns true if the stack is full
    boolean full(Stack s){
        if(s.top == stack.length - 1){
            return true;
        }else{
            return false;
        }
    }

//Method main: Stack will all operations and a max of 451 elements
    public static void main(String[] args) {
        //Stack with maximum 451 Elements
        Stack s = new Stack(451);
        s.init(s);
        //fill stack with 451 elements
        for (int i = 0; i < 451; i++) {
            s.push(s, i);
        }

        //3 Versuche aber dann nacheinander automatisch
        //implement top method
        System.out.println(s.top(s));
        //implement pop method
        System.out.println(s.pop(s));
        //implement empty method
        System.out.println(s.empty(s));
        //implement full method
        System.out.println(s.full(s));
        //implement reverse method
        s.reverse(s);
        System.out.println(s.top(s));
    }

}

