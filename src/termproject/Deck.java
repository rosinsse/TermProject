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
import java.util.Collections;
import java.util.List;

public class Deck {
    
    private final List<Card> cards = new ArrayList<>();

    public Deck(int numDecks) {
        for (int i = 0; i < numDecks; i++) {
            for (Card.Suit suit : Card.Suit.values()) {
                for (Card.Rank rank : Card.Rank.values()) {
                    cards.add(new Card(rank, suit));
                }
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}
