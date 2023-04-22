/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

/**
 *
 * @author SebastianR
 */
import com.mycompany.termcardgame.BlackjackGame;
import com.mycompany.termcardgame.Card;
import com.mycompany.termcardgame.Card.Rank;
import com.mycompany.termcardgame.Card.Suit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameTest {
    
    @Test
    void testInitialPlayerAndDealerHands() {
        BlackjackGame game = new BlackjackGame();
        assertEquals(2, game.getPlayer().getHand().size());
        assertEquals(2, game.getDealer().getHand().size());
    }
    
    @Test
    void testPlayerCanWin() {
        BlackjackGame game = new BlackjackGame();
        game.getPlayer().addCard(new Card(Rank.TEN, Suit.HEARTS));
        game.getPlayer().addCard(new Card(Rank.TEN, Suit.CLUBS));
        game.getDealer().addCard(new Card(Rank.NINE, Suit.DIAMONDS));
        game.getDealer().addCard(new Card(Rank.SIX, Suit.SPADES));
        game.play();
        assertEquals(110, game.getPlayer().getChips());
        assertEquals(99990, game.getDealer().getChips());
    }
    
    @Test
    void testDealerCanWin() {
        BlackjackGame game = new BlackjackGame();
        game.getPlayer().addCard(new Card(Rank.SEVEN, Suit.HEARTS));
        game.getPlayer().addCard(new Card(Rank.SIX, Suit.CLUBS));
        game.getDealer().addCard(new Card(Rank.TEN, Suit.DIAMONDS));
        game.getDealer().addCard(new Card(Rank.TEN, Suit.SPADES));
        game.play();
        assertEquals(90, game.getPlayer().getChips());
        assertEquals(100010, game.getDealer().getChips());
    }
    
    @Test
    void testTie() {
        BlackjackGame game = new BlackjackGame();
        game.getPlayer().addCard(new Card(Rank.JACK, Suit.HEARTS));
        game.getPlayer().addCard(new Card(Rank.QUEEN, Suit.CLUBS));
        game.getDealer().addCard(new Card(Rank.KING, Suit.DIAMONDS));
        game.getDealer().addCard(new Card(Rank.KING, Suit.SPADES));
        game.play();
        assertEquals(100, game.getPlayer().getChips());
        assertEquals(100000, game.getDealer().getChips());
    }
    
}
