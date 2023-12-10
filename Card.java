import java.io.Serializable;

public class Card implements Serializable {

    /*
     * Making data "private" is information hiding, so that it cannot be access by
     * someone else with code outside this class.
     */
    private char suit;
    private int value;

    private Card() {

        suit = ' ';
        value = 0;

    }

    // cards go from 1 to 13 and create newsuit for the cards
    public Card(char newSuit, int newValue) throws InvalidCardValueException, InvalidCardSuitException {
        if (newValue < 1 || newValue > 13) {
            throw new InvalidCardValueException(newValue);
        } else {

            this.value = newValue;
        }
        if (newSuit != 'H' && newSuit != 'S' && newSuit != 'D' && newSuit != 'C') { // (C) clubs (♣), (D) diamonds (♦),
                                                                                    // (H) hearts (♥) and (S) spades (♠)
            throw new InvalidCardSuitException(newSuit);
        } else {
            this.suit = newSuit;
        }

    }

    public String toString() {

        return getSuitName() + " " + this.value;

    }

    public String getSuitName() { // get the name of the cards and display the first letter of the name Ex: Hearts
                                  // display (H) etc

        String suit; // suit is the name of the 4 diffrenet types of cards in the deck (Hearts,
                     // Spades, Culbs, and Diamonds)

        if (this.suit == 'H') {

            suit = "Hearts";

        } else if (this.suit == 'S') {

            suit = "Spades";

        } else if (this.suit == 'C') {

            suit = "Clubs";

        } else if (this.suit == 'D') {

            suit = "Diamonds";

        } else {

            suit = "Unknown";
        }

        return suit;

    }

    public char getSuitDesignator() {

        return suit;

    }

    // get the value of the cards
    public String getValueName() {

        String name = "Unknown";

        if (this.value == 1) {
            name = "Ace";
        } else if (this.value == 2) {
            name = "Two";
        } else if (this.value == 3) {
            name = "Three";
        } else if (this.value == 4) {
            name = "Four";
        } else if (this.value == 5) {
            name = "Five";
        } else if (this.value == 6) {
            name = "Six";
        } else if (this.value == 7) {
            name = "Seven";
        } else if (this.value == 8) {
            name = "Eight";
        } else if (this.value == 9) {

            name = "Nine";
        } else if (this.value == 10) {

            name = "Ten";
        } else if (this.value == 11) {

            name = "Jack";
        } else if (this.value == 12) {

            name = "Queen";
        } else if (this.value == 13) {

            name = "King";

        }
        return name;

    }

    public int getValue() {

        return this.value;
    }

    // compare cards of the same suit
    public boolean compareSuit(Card card) {

        return this.suit == card.getSuitDesignator();

    }

    // compare value of the card
    public boolean compareValue(Card card) {

        return this.value == card.getValue();
    }

    // compare and make sure that cards has the right value and suit
    public boolean compareTo(Card card) {

        return this.suit == card.getSuitDesignator() && this.value == card.getValue();
    }

} // End class