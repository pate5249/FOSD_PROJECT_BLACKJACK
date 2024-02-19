/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author dvptl
 */
public class Deck {
  private List<Card> cards;

    // Constructor for Deck
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    // Method to initialize the deck with all cards
    private void initializeDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }

    // Method to shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw a card from the deck
    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty. Cannot draw a card.");
            return null;
        }
        return cards.remove(0);
    }
}