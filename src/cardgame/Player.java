/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.Scanner;
/**
 *
 * @author dvptl
 */
public class Player {
    private Card[] hand;
    private int numCards;

    // Constructor for Player
    public Player() {
        hand = new Card[10]; // Maximum 10 cards per hand
        numCards = 0;
    }

    // Method to add a card to the player's hand
    public void addCardToHand(Card card) {
        if (numCards < hand.length) {
            hand[numCards] = card;
            numCards++;
        } else {
            System.out.println("Cannot add more cards to hand.");
        }
    }

    // Method to calculate the value of the player's hand
    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (int i = 0; i < numCards; i++) {
            if (hand[i].getValue() == Card.Value.ACE) {
                numAces++;
            }
            value += hand[i].getNumericValue();
        }

        while (value > 21 && numAces > 0) {
            value -= 10; // Convert Ace from 11 to 1
            numAces--;
        }

        return value;
    }

    // Method to get the number of cards in the player's hand
    public int getNumberOfCards() {
        return numCards;
    }
}