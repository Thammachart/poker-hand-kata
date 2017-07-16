package org;

import org.junit.Test;
import org.junit.Assert;

import org.CardTest.Card;

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

    public static class PokerHand {
        private final Card[] cards;

        private PokerHand(Card[] cards) {
            this.cards = cards;
        }

        public Card[] getCards() {
            return cards;
        }

        public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
            cards = new Card[]{ card1, card2, card3, card4, card5 };
        }

        public static PokerHand parse(String ... cards) {
            return new PokerHand(Stream.of(cards).map(Card::parse).toArray(Card[]::new));
        }

        @Override
        public String toString() {
            return Stream.of(cards).map(Card::toString).collect(Collectors.joining(", "));           
        }
    }
}