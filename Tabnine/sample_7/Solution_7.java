/**
 * Solution for
 *
 * Sample_7
 * from Aufgabensammlung zu Algorithmen und Datenstrukturen from Peter Widmayer and Thomas Ottmann
 * example 53 on page 20
 */


//2 Versuche aber auch ganzen text übergeben

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
import java.util.Stack;

public class StackExample {
    private static final int MAX_SIZE = 451;
    private Stack<Integer> stack = new Stack<>();

    public void init() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() == MAX_SIZE) {
            System.out.println("Stack is full.");
        } else {
            stack.push(x);
        }
    }

    public int top() {
        if (stack.empty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack.peek();
        }
    }

    public int pop() {
        if (stack.empty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack.pop();
        }
    }

    public boolean empty() {
        return stack.empty();
    }

    public boolean full() {
        return stack.size() == MAX_SIZE;
    }

    public static void main(String[] args) {
        StackExample stackExample = new StackExample();
        stackExample.init();
        stackExample.push(10);
        stackExample.push(20);
        stackExample.push(30);
        stackExample.push(40);
        System.out.println("Top element: " + stackExample.top());
        System.out.println("Popped element: " + stackExample.pop());
        System.out.println("Stack is empty: " + stackExample.empty());
        System.out.println("Stack is full: " + stackExample.full());
    }
}

import java.util.Scanner;
        import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sequence of numbers separated by spaces:");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
