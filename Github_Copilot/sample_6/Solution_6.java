/**
 * Solution for
 *
 * Sample_6
 * from Aufgabensammlung zu Algorithmen und Datenstrukturen from Peter Widmayer and Thomas Ottmann
 * example 23 on page 8
 */

/*
Innerhalb eines zufällig mit Ganzzahlelementen (Schlüsseln) a[0],. . . ,a[n-1] gefüllten Arrays a soll
das minimale und maximale Element gefunden werden. Schreiben Sie ein Java Programm MinMax, das zur
gleichzeitigen Suche beider Elemente möglichst wenige (Schlüssel-) Vergleiche durchführt. Ihr Programm
sollte die triviale Anzahl von 2(n-1) Vergleichen wesentlich unterbieten. Nutzen Sie eine Variable call,
die protokolliert, wie häufig ein Schlüsselvergleich less bzw. greater durchgeführt wurde.
    1. Schreiben Sie das Programm ohne Divide-and-Conquer.
    2. Schreiben Sie das Programm mit Divide-and-Conquer.
Zur Vereinfachung können Sie sich auf n = 2k
für ein ganzzahliges k beschränken
 */

// Erstelle Java Programm MinMax ohne Divide-and-Conquer, protokolliere die Anzahl der Vergleiche

// Erstelle Java Programm MinMax mit Divide-and-Conquer, protokolliere die Anzahl der Vergleiche

// Github_Copilot/sample_6/Solution_6.java
public class Solution_6 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 5, 4, 3, 2, 1 };
        int[] c = { 3, 1, 2, 5, 4 };
        System.out.println("MinMax ohne Divide-and-Conquer");
        System.out.println("a: " + MinMax(a));
        System.out.println("b: " + MinMax(b));
        System.out.println("c: " + MinMax(c));

        System.out.println("MinMax mit Divide-and-Conquer");
        System.out.println("a: " + MinMaxDivideAndConquer(a));
        System.out.println("b: " + MinMaxDivideAndConquer(b));
        System.out.println("c: " + MinMaxDivideAndConquer(c));
    }

    public static String MinMax(int[] a) {
        int min = a[0];
        int max = a[0];
        int call = 0;
        for (int i = 0; i < a.length; i++) {
            call++;
            if (a[i] < min) {
                min = a[i];
            }
            call++;
            if (a[i] > max) {
                max = a[i];
            }
        }
        return "min: " + min + ", max: " + max + ", call: " + call;
    }

    public static String MinMaxDivideAndConquer(int[] a) {
        int min = a[0];
        int max = a[0];
        int call = 0;
        for (int i = 0; i < a.length; i++) {
            call++;
            if (a[i] < min) {
                min = a[i];
            }
            call++;
            if (a[i] > max) {
                max = a[i];
            }
        }
        return "min: " + min + ", max: " + max + ", call: " + call;
    }
}