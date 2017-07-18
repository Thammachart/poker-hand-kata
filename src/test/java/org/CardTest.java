package org;

import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class CardTest {
    @Test
    public void testCardDiamond2() {
        Card card = new Card("D", "2");
        Assert.assertEquals("D2", card.toString());
    }

    @Test
    public void testCardSpadeQueen() {
        Card card = new Card("S", "Q");
        Assert.assertEquals("SQ", card.toString());
    }

    @Test
    public void testCardInvalidSuit() {
        try { 
            Card card = new Card("M", "1");
            Assert.fail();
        } catch(IllegalArgumentException e) {}
    }

    @Test
    public void testCardInvalidValue() {
        try {
            Card card = new Card("S", "+");
            Assert.fail();
        } catch(IllegalArgumentException e) {}
    }

    @Test
    public void testParseCard() {
        Card card = Card.parse("H2");
        Assert.assertEquals(new Card("H", "2"), card);
    }
}