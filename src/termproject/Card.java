/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.termcardgame;

/**
 *
 * @author SebastianR
 */
public class Card {

    public enum Rank {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
        EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);

        private final int value;

        private Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES;
    }

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue() {
        return rank.getValue();
    }
    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
