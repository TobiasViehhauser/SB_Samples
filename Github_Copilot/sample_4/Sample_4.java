/**
 * Sample_4
 * from Sprechen Sie Java? by Hanspeter Mössenböck
 * example 14.4 on page 202
 */

/*
4. Black Jack. Implementieren Sie das Kartenspiel Black Jack. Dazu benötigen
Sie einen Kartenstapel, in dem jeweils vier Karten der Werte As, König, Dame,
Bube, Zehn, Neun, Acht, Sieben, Sechs, Fünf, Vier, Drei und Zwei liegen. Implementieren Sie die Kartenarten als Enumerationstyp, wobei ein As 11
Punkte wert ist, König, Dame und Bube jeweils 10 Punkte und die anderen
Karten so viele Punkte, wie ihr Name aussagt.
Ein Spieler darf beliebig oft eine zufällige Karte aus dem restlichen Stapel
ziehen, wobei die Punkte der gezogenen Karten addiert werden. Gewonnen
hat, wessen Punkte am nähesten bei 21 liegen, diesen Wert aber nicht überschreiten.
Um eine zufällige Karte zu ziehen, verwenden Sie einen Zufallszahlengenerator in Form der Klasse java.util.Random (siehe [JDK]). Damit können Sie eine
Zufallszahl im Bereich 0 bis n-1 erzeugen, wobei n die Anzahl der noch im Stapel befindlichen Karten ist, zum Beispiel:
java.util.Random random = new java.util.Random();
...
int i = random.nextInt(n); // liefert eine Zufallszahl im Bereich 0 bis n-1

 */


// Enumeration für den Kartenstapel

// Implementiere das Kartenspiel Black Jack

