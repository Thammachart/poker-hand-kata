package org;

public enum CardSuit {
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