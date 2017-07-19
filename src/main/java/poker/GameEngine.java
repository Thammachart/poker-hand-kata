package poker;

import java.util.stream.*;

import poker.card.Card;
import poker.hands.PokerHand;

public class GameEngine {
    public String duel(PokerHand handA, PokerHand handB) {
        return highestCardResult(handA.getCards(), handB.getCards());
    }

    private String highestCardResult(final Card[] _cardsA, final Card[] _cardsB) {
        Card[] cardsA = sort(_cardsA);
        Card[] cardsB = sort(_cardsB);

        for(int i = cardsA.length - 1; i >= 0; i--) {
            int result = cardsA[i].compareTo(cardsB[i]);
            if(result > 0)
                return "A wins";
            else if(result < 0)
                return "B wins";
        }
        return "Tie";
    }

    protected Card[] sort(Card[] cards) {
        return Stream.of(cards).sorted().toArray(Card[]::new);
    }

    protected Card highestCard(Card[] cards) {
        return Stream.of(cards).max(Card::compareTo).get();
    }
}