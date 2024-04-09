
package cardgame;

import java.util.Arrays;


/**
 *
 * @author DvPtl
 */
public class Player {
    private Card[] hands;
    private int numsOfCards;

    // Constructor for the Player
    public Player() {
        hands = new Card[10]; // Maximum 10 cards per hands
        numsOfCards = 0;
    }

    // Method to add a card to the player's hands
    public void addCardTohands(Card card) {
        if (numsOfCards < hands.length) {
            hands[numsOfCards] = card;
            numsOfCards++;
        } else {
            System.out.println("Cannot add more cards to hand.");
        }
    }

    // Method to calculate the value of the player's hand
    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (int i = 0; i < numsOfCards; i++) {
            if (hands[i].getValue() == Card.Value.ACE) {
                numAces++;
            }
            value += hands[i].getNumericValues();
        }

        while (value > 21 && numAces > 0) {
            value -= 10; // Convert into Ace from 11 to 1
            numAces--;
        }

        return value;
    }

    // Method to get the number of cards in the player's hand
    public int getNumberOfCards() {
        return numsOfCards;
    }

    // Method to get the array of cards in the player's hand
    public String getHand() {
        StringBuilder handString = new StringBuilder();
        for (int i = 0; i < numsOfCards; i++) {
            handString.append(hands[i].getValue()).append(" of ").append(hands[i].getSuits()).append("\n");
        }
        return handString.toString();
    }
}