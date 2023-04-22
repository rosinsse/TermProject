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
import com.mycompany.termcardgame.Card.Rank;
import java.util.ArrayList;

public class Player {
    private String name;
    private int chips;
    private ArrayList<Card> hand;
    
    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        this.hand = new ArrayList<Card>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getChips() {
        return this.chips;
    }
    
    public void setChips(int chips) {
        this.chips = chips;
    }
    public void addCard(Card card) {
        hand.add(card);
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public int getHandValue() {
        int handValue = 0;
        int numAces = 0;
        
        for (Card card : hand) {
            if (card.getRank() == Rank.ACE) {
                numAces++;
            }
            handValue += card.getRank().getValue();
        }
        
        while (handValue > 21 && numAces > 0) {
            handValue -= 10;
            numAces--;
        }
        
        return handValue;
    }
}
