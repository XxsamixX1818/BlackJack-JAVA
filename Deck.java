import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Deck extends Exception implements Serializable {

    private int nextCardIndex;

    Card[] deck = new Card[52]; // number of cards in the deck are 52

    public Deck() { // four diffrent types of cards in the deck of 52

        int count = 0;
        try {
            for (int i = 1; i <= 13; i++) {
                deck[count++] = new Card('H', i); // hearts (♥)
            }
            for (int i = 1; i <= 13; i++) {
                deck[count++] = new Card('S', i); // spades (♠)
            }
            for (int i = 1; i <= 13; i++) {
                deck[count++] = new Card('C', i); // clubs (♣)
            }
            for (int i = 1; i <= 13; i++) {
                deck[count++] = new Card('D', i); // diamonds (♦)
            }
        }

        catch (InvalidCardValueException | InvalidCardSuitException exp1) {

        }
        nextCardIndex = 0;
    }

    private void isIndexGood(int index) throws InvalidDeckPositionException {
        if (index < 0 || index > 51) {
            throw new InvalidDeckPositionException(index);
        }
    }

    public String toString() {

        String str = "";

        for (int i = 0; i < deck.length; i++) {
            str += deck[i].toString() + " ";
        }
        return str;
    }

    // swap the 2 cards in the deck
    private void swapCards(int index1, int index2) throws InvalidDeckPositionException {
        Card hold;

        isIndexGood(index1);
        isIndexGood(index2);
        hold = deck[index1];
        deck[index1] = deck[index2];
        deck[index2] = hold;
    }

    // shuffle the deck
    public void shuffle() throws InvalidDeckPositionException {
        Random rn = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < deck.length; j++) {
                swapCards(i, rn.nextInt(52));
            }
        }
        nextCardIndex = 0;
    }

    // get the card from the deck
    public Card getCard(int index) throws InvalidDeckPositionException {
        isIndexGood(index);
        return deck[index];
    }

    // compare the Deck to otherDeck
    public boolean compareTo(Deck otherDeck) throws InvalidDeckPositionException {
        for (int i = 0; i < deck.length; i++) {
            if (!deck[i].compareTo(otherDeck.getCard(i))) {
                return false;
            }
        }
        return true;
    }

    // next card
    public Card nextCard() {

        if (nextCardIndex < 0 || nextCardIndex > 51) {
            System.out.println("Future exception goes here");
        }
        return deck[nextCardIndex++];
    }

} // End class
