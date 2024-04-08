
package cardgame;

import java.util.Scanner;

/**
 *
 * @author DvPtl
 */

public class BlackjackGame {
    private Player player;
    private Player dealer;
    private Deck deck;
    private Scanner scanner;

    // Constructor for BlackjackGame
    public BlackjackGame() {
        // Initialize player, dealer, and deck
        player = new Player();
        dealer = new Player();
        deck = new Deck();
        scanner = new Scanner(System.in);
    }

    // Method to start the Blackjack game
    public void play() {
        // Shuffle the deck
        deck.shuffle();

        // Get player's name and bet amount
        System.out.println("Enter player's name:");
        String playerName = scanner.nextLine();
        System.out.println("Enter amount of money to bet:");
        int betAmount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Deal initial cards to player and dealer
        player.addCardTohands(deck.drawCard());
        dealer.addCardTohands(deck.drawCard());
        player.addCardTohands(deck.drawCard());
        dealer.addCardTohands(deck.drawCard());

        // Display initial hands
        System.out.println("Player's Hands: " + player.getHandValue());
        System.out.println("Dealer's Hands: " + dealer.getHandValue());

        // Player's turn
        if (!GameLogic.isPlayerDone(player)) {
            playerAction();
        }

        // Dealer's turn
        while (!GameLogic.isDealersDone(dealer) && !GameLogic.isBust(dealer)) {
            dealer.addCardTohands(deck.drawCard());
            System.out.println("Dealer's Hands: " + dealer.getHandValue());
        }

        // Determine winner
        GameLogic.determineWinner(player, dealer);
    }

    // Method to prompt player for action (hit or stand)
    private void playerAction() {
        System.out.println("Do you want to take hit or stand? (h/s)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("h")) {
            player.addCardTohands(deck.drawCard());
            System.out.println("Player's Hand after hitting: " + player.getHandValue());
            if (GameLogic.isBust(player)) {
                System.out.println("Player busts! Dealer wins.");
                System.exit(0); // Exit game
            } else if (!GameLogic.isPlayerDone(player)) {
                playerAction(); // Prompt to the player for action again if they choose to hit
            }
        }
    }
}