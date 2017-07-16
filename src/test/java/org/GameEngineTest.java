package org;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

import java.util.stream.*;

import org.PokerHandTest.PokerHand;
import org.CardTest.Card;
import org.CardTest.CardValue;

public class GameEngineTest {
    private GameEngine gameEngine = new GameEngine();

    @Test
    public void testHighCardPlayerAWin() {
        PokerHand handA = PokerHand.parse("H2", "D3", "S5", "C9", "DK");
        PokerHand handB = PokerHand.parse("C2", "H3", "S4", "C8", "HA");

        String result = gameEngine.duel(handA, handB);
        Assert.assertEquals("A wins", result);
    }

    @Test
    public void testHighCardPlayerBWin() {
        PokerHand handA = PokerHand.parse("C2", "H3", "S4", "C8", "HA");
        PokerHand handB = PokerHand.parse("H2", "D3", "S5", "C9", "DK");

        String result = gameEngine.duel(handA, handB);
        Assert.assertEquals("B wins", result);
    }

    @Test
    public void testHighCardTie() {
        PokerHand handA = PokerHand.parse("C2", "H3", "S4", "C8", "HA");
        PokerHand handB = PokerHand.parse("C2", "H3", "S4", "C8", "HA");

        String result = gameEngine.duel(handA, handB);
        Assert.assertEquals("Tie", result);
    }

    @Test
    @Ignore
    public void testPlayerAWinWithSecondHighestCard() {
        PokerHand handA = PokerHand.parse("C2", "H3", "S5", "C8", "HA");
        PokerHand handB = PokerHand.parse("C2", "H3", "S4", "C8", "HA");

        String result = gameEngine.duel(handA, handB);
        Assert.assertEquals("A wins", result);
    }

    public static class GameEngine {
        public String duel(PokerHand handA, PokerHand handB) {
            Card[] cardsA = handA.getCards();
            Card[] cardsB = handB.getCards();

            Card maxValueA = highestCard(handA.getCards());
            Card maxValueB = highestCard(handB.getCards());

            int result = maxValueA.compareTo(maxValueB);
            if(result > 0)
                return "A wins";
            else if(result < 0)
                return "B wins";
            
            return "Tie";
        }

        protected Card highestCard(Card[] cards) {
            return Stream.of(cards).max(Card::compareTo).get();
        }
    }
}