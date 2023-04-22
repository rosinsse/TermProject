/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.termcardgame;

/**
 *
 * @author SebastianR
 */
import com.mycompany.termcardgame.Deck;
import com.mycompany.termcardgame.Deck;
import com.mycompany.termcardgame.Player;
import com.mycompany.termcardgame.Player;
import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Player dealer;

    public BlackjackGame() {
        deck = new Deck(6);
        player = new Player("Player", 100);
        dealer = new Player("Dealer", 100000);
    }
    public Deck getDeck() {
    return deck;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        // Shuffle the deck
        deck.shuffle();

        // Deal two cards to the player and dealer
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        // Player's turn
        while (true) {
            System.out.println("Your hand: " + player.getHand());
            System.out.println("Dealer's hand: " + dealer.getHand().get(0) + ", [hidden]");
            System.out.print("Do you want to hit or stand? ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("hit")) {
                player.addCard(deck.drawCard());
                if (player.getHandValue() > 21) {
                    System.out.println("You bust! Dealer wins.");
                    return;
                }
            } else if (input.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }

        // Dealer's turn
        while (dealer.getHandValue() < 17) {
            dealer.addCard(deck.drawCard());
        }

        // Determine the winner
        System.out.println("Your hand: " + player.getHand());
        System.out.println("Dealer's hand: " + dealer.getHand());
        if (dealer.getHandValue() > 21) {
            System.out.println("Dealer busts! You win.");
        } else if (player.getHandValue() > dealer.getHandValue()) {
            System.out.println("You win!");
        } else if (player.getHandValue() < dealer.getHandValue()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("Push!");
        }
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.play();
    }
}

