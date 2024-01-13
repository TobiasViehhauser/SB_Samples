// H. Moessenboeck: Sprechen Sie Java? -- Kapitel 14, Aufgabe 4
// "Black Jack"

//-------------------------------------------------------------
// The cards and their values
//-------------------------------------------------------------
enum Card {
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
    DEUCE(2);

    private int val; // card value

    Card(int value) { val = value;	}

    int value() { return val; }
}

//-------------------------------------------------------------
// The card stack
//-------------------------------------------------------------
class CardStack {
    Card[] cards; // card stack
    int n;        // number of cards in the stack
    java.util.Random random = new java.util.Random();

    // set up a stack of 52 cards
    CardStack() {
        cards = new Card[] {
                Card.ACE, Card.KING, Card.QUEEN, Card.JACK, Card.TEN, Card.NINE, Card.EIGHT,
                Card.SEVEN, Card.SIX, Card.FIVE, Card.FOUR, Card.THREE, Card.DEUCE,
                Card.ACE, Card.KING, Card.QUEEN, Card.JACK, Card.TEN, Card.NINE, Card.EIGHT,
                Card.SEVEN, Card.SIX, Card.FIVE, Card.FOUR, Card.THREE, Card.DEUCE,
                Card.ACE, Card.KING, Card.QUEEN, Card.JACK, Card.TEN, Card.NINE, Card.EIGHT,
                Card.SEVEN, Card.SIX, Card.FIVE, Card.FOUR, Card.THREE, Card.DEUCE,
                Card.ACE, Card.KING, Card.QUEEN, Card.JACK, Card.TEN, Card.NINE, Card.EIGHT,
                Card.SEVEN, Card.SIX, Card.FIVE, Card.FOUR, Card.THREE, Card.DEUCE,
        };
        n = cards.length;
    }

    // draw a random card (there are n cards on the stack)
    Card draw() {
        int i = random.nextInt(n);
        Card res = cards[i];
        while (i < n - 1) {cards[i] = cards[i+1]; i++; }
        n--;
        return res;
    }

}

//-------------------------------------------------------------
// The Black Jack game
//-------------------------------------------------------------
public class A4 {

    public static void main(String[] arg) {
        while (true) {
            Out.print("another game (y|n)? ");
            String cmd = In.readWord();
            if (cmd.equals("n")) break;
            Out.println();

            CardStack stack = new CardStack();
            int sum = 0;
            while (true) {
                Out.print("draw again (y|n)? ");
                cmd = In.readWord();
                if (cmd.equals("n")) break;
                Card card = stack.draw();
                sum += card.value();
                Out.println("  " + card.toString() + ": " + card.value() + ", sum = " + sum);
                if (sum > 21) break;
            }
            if (sum > 21) Out.println("too much!");
            else Out.println("you have " + sum + " points");
            Out.println();
        }
    }
}
