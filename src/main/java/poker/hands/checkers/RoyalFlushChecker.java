package poker.hands.checkers;

import java.util.stream.Stream;

import poker.hands.PokerHand;
import poker.hands.HandValue;
import poker.card.Card;
import poker.card.CardValue;

public class RoyalFlushChecker implements PokerHandChecker {
    @Override
    public boolean isValid(PokerHand hand) {
        return allSameSuit(hand.getCards()) && isRoyalConsecutive(hand.getCards());
    }

    private boolean allSameSuit(Card[] cards) {
        return Stream.of(cards).allMatch(card -> card.getSuit() == cards[0].getSuit());
    }

    private boolean isRoyalConsecutive(Card[] cards) {
        return Stream.of(cards).allMatch(card ->
                card.getValue() == CardValue._T ||
                card.getValue() == CardValue._J ||
                card.getValue() == CardValue._Q ||
                card.getValue() == CardValue._K ||
                card.getValue() == CardValue._A);
    }

    @Override
    public int getValue() {
        return HandValue.ROYALFLUSH.ordinal();
    }

    @Override
    public String duel(PokerHand handA, PokerHand handB) {
        return "Tie";
    }
}
