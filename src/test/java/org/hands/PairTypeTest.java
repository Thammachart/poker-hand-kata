package org.hands;

import org.junit.Test;
import org.junit.Assert;

import org.PokerHand;
import org.Card;

public class PairTypeTest {
    @Test
    public void testValidPokerHand() {
        HandType pairType = new PairType();
        PokerHand hand = new PokerHand(new Card("H", "2"), new Card("S", "4"), new Card("C", "4"), new Card("D", "7"), new Card("H", "9"));
        
        Assert.assertTrue(pairType.isValid(hand));
    }
}