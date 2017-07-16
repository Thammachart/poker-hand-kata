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

    public static enum CardSuit {
        C("C"), D("D"), H("H"), S("S");

        private String symbol;

        CardSuit(String symbol) {
            this.symbol = symbol;
        }

        static CardSuit parse(String s) {
            for(CardSuit suit: CardSuit.values()) {
                if (suit.symbol.equals(s)) {
                    return suit;
                }
            }

            throw new IllegalArgumentException("Invalid suit: " + s);
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }
    public static enum CardValue {
        _A(1, "A"),_2(2, "2"), _3(3, "3"), _4(4, "4"), _5(5, "5"), _6(6, "6"), _7(7, "7"), 
        _8(8, "8"), _9(9, "9"), _T(10, "T"), _J(11, "J"), _Q(12, "Q"), _K(13, "K");

        private int val;
        private String text;

        CardValue(int val, String text) {
            this.val = val;
            this.text = text;
        }

        static CardValue parse(String s) {
            for(CardValue value: CardValue.values()) {
                if (value.text.equals(s)) {
                    return value;
                }
            }

            throw new IllegalArgumentException("Invalid value: " + s);
        }

        int getCardValue() {
            return this.val;
        }

        @Override
        public String toString() {
            return this.text;
        }
    }

    public static class Card implements Comparable<Card> {
        private final CardSuit suit;
        private final CardValue value;

        public static Card parse(String card) {
            return new Card(card.charAt(0) + "", card.charAt(1) + "");
        }

        public Card(String suit, String value) {
            this(CardSuit.parse(suit), CardValue.parse(value));
        }

        public Card(CardSuit suit, CardValue value) {
            this.suit = suit;
            this.value = value;
        }

        public CardValue getValue() {
            return this.value;
        }

        @Override
        public int compareTo(Card card) {
            return this.value.compareTo(card.value);
        }

        @Override
        public String toString() {
            return this.suit.toString() + this.value.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Card)) {
                return false;
            }
            
            Card card = (Card) o;
            return  Objects.equals(suit, card.suit) &&
                    Objects.equals(value, card.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(suit, value);
        }
    }   
}