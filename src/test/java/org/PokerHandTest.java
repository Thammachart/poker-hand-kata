package org;

import org.junit.Test;
import org.junit.Assert;

import java.util.stream.*;

public class PokerHandTest {
    @Test
    public void testPokerHandMustHaveFiveCards() {
        PokerHand hand = new PokerHand(new Card("D", "A"), new Card("S", "2"), new Card("H", "Q"), new Card("C", "K"), new Card("S", "8"));
    }

    @Test
    public void testToString() {
        PokerHand hand = new PokerHand(new Card("D", "A"), new Card("S", "2"), new Card("H", "Q"), new Card("C", "K"), new Card("S", "8"));
        Assert.assertEquals("DA, S2, HQ, CK, S8", hand.toString());
    }

    @Test
    public void testHandParsing() {
        PokerHand hand = PokerHand.parse("H2", "D3", "S5", "C9", "DK");
        Assert.assertEquals("H2, D3, S5, C9, DK", hand.toString());
    }
}