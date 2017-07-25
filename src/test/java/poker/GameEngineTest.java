/*
    Issues:
        Conviction
        Observe your own Body Language, and colleage
        Calm yourself in the middle of process
*/

package poker;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

import java.util.stream.*;
import java.util.Arrays;

import poker.card.Card;
import poker.hands.PokerHand;

public class GameEngineTest {
    private GameEngine gameEngine = new GameEngine();

    @Test
    public void testHighCardPlayerAWin() {
        PokerHand handA = PokerHand.parse("C2", "H3", "S4", "C8", "HA");
        PokerHand handB = PokerHand.parse("H2", "D3", "S5", "C9", "DK");

        String result = gameEngine.duel(handA, handB);
        Assert.assertEquals("A wins", result);
    }

    @Test
    public void testHighCardPlayerBWin() {
        PokerHand handA = PokerHand.parse("H2", "D3", "S5", "C9", "DK");
        PokerHand handB = PokerHand.parse("C2", "H3", "S4", "C8", "HA");

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
    public void testPlayerAWinWithSecondHighestCard() {
        PokerHand handA = PokerHand.parse("C2", "H3", "S5", "C8", "HA");
        PokerHand handB = PokerHand.parse("C2", "H3", "S4", "C8", "HA");

        String result = gameEngine.duel(handA, handB);
        Assert.assertEquals("A wins", result);
    }

    @Test
    public void testPlayerAWinWithLastHighestCard() {
        PokerHand handA = PokerHand.parse("H3", "C5", "H6", "S7", "C8");
        PokerHand handB = PokerHand.parse("H4", "C5", "H6", "S7", "C8");

        String result = gameEngine.duel(handA, handB);
        Assert.assertEquals("B wins", result);
    }
}
