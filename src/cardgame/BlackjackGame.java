
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
        System.out.println(playerName + "'s Hand: ");
        System.out.println(player.getHand());
        System.out.println("Total: " + player.getHandValue()); // Display total of player's hand
        System.out.println("Dealer's Hand: ");
        System.out.println(dealer.getHand());
        System.out.println("Total: " + dealer.getHandValue()); // Display total of dealer's hand

        // Player's turn
        if (!GameLogic.isPlayerDone(player)) {
            playerAction();
        }

        // Display dealer's hand if player stood
        System.out.println("Dealer's Hands: ");
        System.out.println(dealer.getHand());
        System.out.println("Total: " + dealer.getHandValue()); // Display total of dealer's hand

        // Dealer's turn
        while (!GameLogic.isDealersDone(dealer) && !GameLogic.isBust(dealer)) {
            dealer.addCardTohands(deck.drawCard());
            System.out.println("Dealer's Hands: ");
            System.out.println(dealer.getHand());
            System.out.println("Total: " + dealer.getHandValue()); // Display total of dealer's hand
        }

        // Determine winner
        GameLogic.determineWinner(player, dealer);
    }

    // Method to prompt player for action (hit or stand)
    private void playerAction() {
        while (true) {
            System.out.println("Do you want to take hit or stand? (h/s)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.addCardTohands(deck.drawCard());
                System.out.println("Player's Hand after hitting: ");
                System.out.println(player.getHand());
                System.out.println("Total: " + player.getHandValue()); // Display total of player's hand
                if (GameLogic.isBust(player)) {
                    System.out.println("Player busts! Dealer wins.");
                    System.exit(0); // Exit game
                } else if (GameLogic.isPlayerDone(player)) {
                    break; // Player stands, exit loop
                }
            } else if (choice.equalsIgnoreCase("s")) {
                break; // Player stands, exit loop
            } else {
                System.out.println("Invalid input. Please enter 'h' for hit or 's' for stand.");
            }
        }
    }
}