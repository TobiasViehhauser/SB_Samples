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
import java.util.Random;

public class MinMax {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(100);
        }
        int min = a[0], max = a[0];
        int call = 0;
        for (int i = 1; i < n; i++) {
            call++;
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("Minimum: " + min + ", Maximum: " + max + ", Comparisons: " + call);
    }
}

// Erstelle Java Programm MinMax mit Divide-and-Conquer, protokolliere die Anzahl der Vergleiche

import java.util.Random;

public class MinMax {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(100);
        }
        int min = a[0], max = a[0];
        int call = 0;
        if (n > 1) {
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];
            for (int i = 0; i < mid; i++) {
                left[i] = a[i];
            }
            for (int i = mid; i < n; i++) {
                right[i - mid] = a[i];
            }
            MinMax mm1 = new MinMax();
            mm1.findMinMax(left, min, max, call);
            MinMax mm2 = new MinMax();
            mm2.findMinMax(right, min, max, call);
            if (min > mm2.min) {
                min = mm2.min;
            }
            if (max < mm2.max) {
                max = mm2.max;
            }
            call += mm1.call + mm2.call;
        } else {
            min = a[1];
            max = a[1];
        }
        System.out.println("Minimum: " + min + ", Maximum: " + max + ", Comparisons: " + call);
    }

    public void findMinMax(int[] a, int min, int max, int call) {
        if (a.length > 1) {
            int mid = a.length / 2;
            int[] left = new int[mid];
            int[] right = new int[a.length - mid];
            for (int i = 0; i < mid; i++) {
                left[i] = a[i];
            }
            for (int i = mid; i < a.length; i++) {
                right[i - mid] = a[i];
            }
            findMinMax(left, min, max, call);
            findMinMax(right, min, max, call);
            if (min > a[mid - 1]) {
                min = a[mid - 1];
            }
            if (max < a[mid - 1]) {
                max = a[mid - 1];
            }
            call++;
        } else {
            if (min > a[0]) {
                min = a[0];
            }
            if (max < a[0]) {
                max = a[0];
            }
            call++;
        }
    }
}