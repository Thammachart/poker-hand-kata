package poker.hands.checkers;

import org.junit.Test;
import org.junit.Assert;

import poker.card.Card;
import poker.hands.PokerHand;

public class RoyalFlushCheckerTest {
    private PokerHandChecker checker = new RoyalFlushChecker();

    @Test
    public void testChecker() {
        PokerHand hand = PokerHand.parse("SA", "SJ", "SQ", "SK", "ST");
        boolean result = checker.isValid(hand);
        Assert.assertTrue(result);
    }

    @Test
    public void testCheckerInvalidHandNotStraight() {
        PokerHand hand = PokerHand.parse("SA", "SJ", "SQ", "SK", "S9");
        boolean result = checker.isValid(hand);
        Assert.assertFalse(result);
    }

    @Test
    public void testCheckerInvalidHandNotFlush() {
        PokerHand hand = PokerHand.parse("SA", "SJ", "CQ", "SK", "ST");
        boolean result = checker.isValid(hand);
        Assert.assertFalse(result);
    }

    @Test
    public void testCheckerBothHandsRoyalFlush() {
        PokerHand handA = PokerHand.parse("SA", "SJ", "SQ", "SK", "ST");
        PokerHand handB = PokerHand.parse("CA", "CJ", "CQ", "CK", "CT");
        String result = checker.duel(handA, handB);
        Assert.assertEquals("Tie", result);
    }
}
