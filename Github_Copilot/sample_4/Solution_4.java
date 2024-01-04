/**
 * Solution for
 *
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
enum Card {
    AS(11), KING(10), QUEEN(10), JACK(10), TEN(10), NINE(9), EIGHT(8), SEVEN(7), SIX(6), FIVE(5), FOUR(4), THREE(3), TWO(2);
    private int value;

    // Konstruktor
    Card(int value) {
        this.value = value;
    }

    // Methode zum Auslesen des Wertes
    public int getValue() {
        return value;
    }
}

// Klasse für den Kartenstapel
class CardStack {
    private int n; // Anzahl der noch im Stapel befindlichen Karten
    private Card[] cards; // Array für die Karten

    // Konstruktor
    CardStack() {
        n = 52;
        cards = new Card[n];
        int i = 0;
        for (Card card : Card.values()) {
            for (int j = 0; j < 4; j++)
                cards[i++] = card;
        }
    }

    // Methode zum Ziehen einer zufälligen Karte
    public Card draw() {
        java.util.Random random = new java.util.Random();
        int i = random.nextInt(n);
        Card card = cards[i];
        cards[i] = cards[--n];
        return card;
    }
}

// Klasse für den Spieler
class Player {
    private int points; // Punkte des Spielers

    // Konstruktor
    Player() {
        points = 0;
    }

    // Methode zum Ziehen einer Karte
    public void draw(Card card) {
        points += card.getValue();
    }

    // Methode zum Auslesen der Punkte
    public int getPoints() {
        return points;
    }
}

// Klasse für das Spiel
class BlackJack {
    public static void main(String[] args) {
        CardStack stack = new CardStack();
        Player player = new Player();
        while (true) {
            Card card = stack.draw();
            player.draw(card);
            System.out.println("Karte: " + card + ", Punkte: " + player.getPoints());
            if (player.getPoints() > 21) {
                System.out.println("Verloren!");
                break;
            }
        }
    }
}

// Kartenspiel Black Jack
