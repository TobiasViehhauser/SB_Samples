import java.util.Random;

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
//create enum Class card

enum Card {

    //Erste Zeile musste 2 mal aber dafür 2. Kommentar automatisch erstellt
    //Values Ace, King, Queen, Jack, Ten, Nine, Eight, Seven, Six, Five, Four, Three and Two are
    //assigned with the value of 11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3 and 2 respectively.

    Ace(11), King(10), Queen(10), Jack(10), Ten(10), Nine(9), Eight(8), Seven(7), Six(6), Five(5), Four(4), Three(3), Two(2);

    //erster Versuch
    //Create Constructor for Card
    private int value;
    Card(int value) {
        this.value = value;

}

//Create Class for the card deck as an Array with Card Objects
//create class deck

class Deck {

    //2 Versuche, aber dafür Shuffle methode automatisch
    //Create Array with Card Objects
    private Card[] cards = new Card[52];

    //Create Constructor for the Deck
    Deck() {
        //Create a new Card Object for each Card in the Deck
        int i = 0;
        for (Card card : Card.values()) {
            cards[i] = card;
            i++;
        }
    }

    //Create Method to shuffle the Deck
    void shuffle() {
        //Create a new Random Object
        Random random = new Random();
        //Create a new Card Object for each Card in the Deck
        for (int i = 0; i < cards.length; i++) {
            //Create a new Card Object for each Card in the Deck
            Card card = cards[i];
            //Create a new Card Object for each Card in the Deck
            int j = random.nextInt(cards.length);
            //Create a new Card Object for each Card in the Deck
            cards[i] = cards[j];
            //Create a new Card Object for each Card in the Deck
            cards[j] = card;

        }
    }

    //erster Versuch + Klasse automatisch importiert
    //create method to draw a random card from the deck with the help of java.util.random
    Card draw() {
        //Create a new Random Object
        Random random = new Random();
        //Create a new Card Object for each Card in the Deck
        int i = random.nextInt(cards.length);
        //Create a new Card Object for each Card in the Deck
        Card card = cards[i];
        //Create a new Card Object for each Card in the Deck
        return card;
    }

}

//create a class For a player
class Player {

        // 3 Versuche, aber immer noch nicht richtig
        //create method for drawing cards and adding the values of the cards
        int drawCard(Deck deck) {
            //Create a new Card Object for each Card in the Deck
            Card card = deck.draw();
            //Create a new Card Object for each Card in the Deck
            return card.value;
        }
}

//Create a class for the game
class Game {
    // 2 Versuche
    //create method for the game
    void play() {
        //Create a new Deck Object
        Deck deck = new Deck();
        //Create a new Player Object
        Player player = new Player();
        //Create a new Card Object for each Card in the Deck
        int sum = 0;
        //Create a new Card Object for each Card in the Deck

        while (sum < 21) {
            //Create a new Card Object for each Card in the Deck
            sum += player.drawCard(deck);
            //Create a new Card Object for each Card in the Deck
            System.out.println("Sum: " + sum);
        }
    }
}



