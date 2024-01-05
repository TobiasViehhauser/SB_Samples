import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

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


//Auch erster Versuch ganzer Text wurde übergeben aus der Angabe
public class BlackJack {
    // Enumeration for the deck of cards
    private enum CardValue {
        ACE(11),
        KING(10),
        QUEEN(10),
        JACK(10),
        TEN(10),
        NINE(9),
        EIGHT(8),
        SEVEN(7),
        SIX(6),
        FIVE(5),
        FOUR(4),
        THREE(3),
        TWO(2);

        private int value;

        CardValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    // Class representing a single card
    private static class Card {
        private CardValue value;
        private Suit suit;

        private Card(CardValue value, Suit suit) {
            this.value = value;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return value + " of " + suit;
        }
    }

    // Enumeration for the suits
    private enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    // Class representing a deck of cards
    private static class Deck {
        private List<Card> cards = new ArrayList<>();

        // Constructor for creating a new deck of cards
        public Deck() {
            for (CardValue value : CardValue.values()) {
                for (Suit suit : Suit.values()) {
                    cards.add(new Card(value, suit));
                }
            }
        }

        // Shuffle the deck
        public void shuffle() {
            Collections.shuffle(cards);
        }

        // Draw a card from the deck
        public Card draw() {
            return cards.remove(cards.size() - 1);
        }
    }

    // Class representing a player in the game
    private static class Player {
        private int points;
        private boolean busted;

        public Player() {
            points = 0;
            busted = false;
        }

        // Draw a card from the deck and add its points to the player's total
        public void drawCard(Deck deck) {
            Card card = deck.draw();
            points += card.getValue();
            if (points > 21) {
                busted = true;
            }
        }

        @Override
        public String toString() {
            return "Points: " + points + ", Busted: " + busted;
        }
    }

    // Main method for playing the game
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        Player dealer = new Player();

        // Deal two cards to each player
        player.drawCard(deck);
        dealer.drawCard(deck);
        player.drawCard(deck);

        // Continue drawing cards until one of the players busts or reaches 21 points
        while (!player.busted && dealer.points < 17) {
            player.drawCard(deck);
            if (player.busted) {
                break;
            }
            dealer.drawCard(deck);
        }

        // Determine the winner
        if (dealer.points < 21 && dealer.points > player.points) {
            System.out.println("You lose. The dealer wins.");
        } else if (dealer.points >= 21) {
            System.out.println("You win. The dealer busts.");
        } else if (player.points > 21) {
            System.out.println("You lose. The dealer wins.");
        } else {
            System.out.println("You win.");
        }
    }
}