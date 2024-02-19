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
public class BlackjackGame {
   private Player player;
    private Player dealer;
    private Deck deck;

    // Constructor for BlackjackGame
    public BlackjackGame() {
        // Initialize player, dealer, and deck
        player = new Player();
        dealer = new Player();
        deck = new Deck();
    }

    // Method to start the Blackjack game
    public void play() {
        // Shuffle the deck
        deck.shuffle();

        // Deal initial cards to player and dealer
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());

        // Display initial hands
        System.out.println("Player's Hand: " + player.getHandValue());
        System.out.println("Dealer's Hand: " + dealer.getHandValue());

        // Player's turn
        if (!GameLogic.isPlayerDone(player)) {
            playerAction();
        }

        // Dealer's turn
        while (!GameLogic.isDealerDone(dealer) && !GameLogic.isBust(dealer)) {
            dealer.addCardToHand(deck.drawCard());
            System.out.println("Dealer's Hand: " + dealer.getHandValue());
        }

        // Determine winner
        GameLogic.determineWinner(player, dealer);
    }

    // Method to prompt player for action (hit or stand)
    private void playerAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to hit or stand? (h/s)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("h")) {
            player.addCardToHand(deck.drawCard());
            System.out.println("Player's Hand after hitting: " + player.getHandValue());
            if (GameLogic.isBust(player)) {
                System.out.println("Player busts! Dealer wins.");
                System.exit(0); // Exit the game
            } else if (!GameLogic.isPlayerDone(player)) {
                playerAction(); // Prompt player for action again if they choose to hit
            }
        }
    }
}