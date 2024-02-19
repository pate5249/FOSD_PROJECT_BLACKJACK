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
public class GameLogic {
   public static final int BLACKJACK_VALUE = 21;

    // Method to check if a player has a Blackjack
    public static boolean isBlackjack(Player player) {
        return player.getHandValue() == BLACKJACK_VALUE && player.getNumberOfCards() == 2;
    }

    // Method to check if a player has busted (hand value exceeds 21)
    public static boolean isBust(Player player) {
        return player.getHandValue() > BLACKJACK_VALUE;
    }

    // Method to check if the dealer is done (hand value >= 17)
    public static boolean isDealerDone(Player dealer) {
        return dealer.getHandValue() >= 17;
    }

    // Method to check if the player is done (hit or stand)
    public static boolean isPlayerDone(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to hit or stand? (h/s)");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("s");
    }

    // Method to determine the winner of the game
    public static void determineWinner(Player player, Player dealer) {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        if (playerValue > BLACKJACK_VALUE) {
            System.out.println("Player busts! Dealer wins.");
        } else if (dealerValue > BLACKJACK_VALUE) {
            System.out.println("Dealer busts! Player wins.");
        } else if (playerValue == dealerValue) {
            System.out.println("It's a tie!");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
    }
}