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

//3 Versuche mit verschiedenen kommentaren
//Function to find min and max without Divide-and-Conquer
public class Solution {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int min = a[0];
        int max = a[0];
        int call = 0;
        for (int i = 1; i < a.length; i++) {
            call++;
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("Min: " + min + " Max: " + max + " Calls: " + call);
    } //main() end
}

//1. Versuch
// Function to find min and max with Divide-and-Conquer
public class SolutionDivideAndConquer {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int min = a[0];
        int max = a[0];
        int call = 0;
        int n = a.length;
        int[] b = new int[n/2];
        int[] c = new int[n/2];
        if (n > 2) {
            for (int i = 0; i < n/2; i++) {
                b[i] = a[i];
                c[i] = a[i + n/2];
            }
            int[] bMin = minMax(b);
            int[] cMin = minMax(c);
            min = Math.min(bMin[0], cMin[0]);
            max = Math.max(bMin[1], cMin[1]);
            call = bMin[2] + cMin[2];
        }
        System.out.println("Min: " + min + " Max: " + max + " Calls
}


//FUnktioniert nicht wirklich zu generieren
//function to test the methods
public static void test() {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
    int[] b = minMax(a);
    System.out.println("Min: " + b[0] + " Max: " + b[1] + " Calls: " + b[2]);
}
