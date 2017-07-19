package poker.hands;

import java.util.stream.*;

import poker.card.*;

public class PokerHand {
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