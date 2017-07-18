package org.hands;

import org.junit.Test;
import org.junit.Assert;

import org.PokerHand;
import org.Card;

public class HighCardTypeTest {
    @Test
    public void testValidPokerHand() {
        HandType highCardType = new HighCardType();
        PokerHand hand = new PokerHand(new Card("D", "A"), new Card("S", "2"), new Card("H", "Q"), new Card("C", "K"), new Card("S", "8"));

        Assert.assertTrue(highCardType.isValid(hand));
        Assert.assertEquals(HandTypeValue.HIGHCARD.ordinal(), highCardType.getValue());
    }
}