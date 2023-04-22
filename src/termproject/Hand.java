/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.termcardgame;

/**
 *
 * @author SebastianR
 */
import com.mycompany.termcardgame.Card;
import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    private final List<Card> cards = new ArrayList<>();
    private boolean canSplit = true;

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;
        int numAces = 0;
        for (Card card : cards) {
            int value = card.getValue();
            score += value;
            if (value == 1) {
                numAces++;
            }
        }
        while (numAces > 0 && score <= 11) {
            score += 10;
            numAces--;
        }
        return score;
    }

    public boolean canSplit() {
        if (cards.size() != 2) {
            return false;
        }
        Card first = cards.get(0);
        Card second = cards.get(1);
        return first.getRank() == second.getRank() && canSplit;
    }

    public Hand split() {
        if (!canSplit()) {
            throw new IllegalStateException("Cannot split this hand");
        }
        Hand splitHand = new Hand();
        splitHand.addCard(cards.remove(1));
        canSplit = false;
        return splitHand;
    }

    public boolean canDouble() {
        return cards.size() == 2;
    }

    public void doubleDown(Card card) {
        if (!canDouble()) {
            throw new IllegalStateException("Cannot double down this hand");
        }
        addCard(card);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
